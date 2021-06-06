package it.mycompany.springresthib.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "it.mycompany.springresthib")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfiguration implements WebMvcConfigurer{
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSourceConfig(){
		
		ComboPooledDataSource datasource = new ComboPooledDataSource();
		try {
			datasource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException ex) {
			throw new RuntimeException(ex);
		}	
		datasource.setJdbcUrl(env.getProperty("jdbc.url"));
		datasource.setUser(env.getProperty("jdbc.user"));
		datasource.setPassword(env.getProperty("jdbc.password"));
		
		datasource.setInitialPoolSize(convertToInt("connection.pool.initialPoolSize"));
		datasource.setMinPoolSize(convertToInt("connection.pool.minPoolSize"));
		datasource.setMaxPoolSize(convertToInt("connection.pool.maxPoolSize"));
		datasource.setMaxIdleTime(convertToInt("connection.pool.maxIdleTime"));
		
		return datasource;
	}
	
	private int convertToInt(String propertyName) {
		String value = env.getProperty(propertyName);
		int integerValue = Integer.parseInt(value);
		return integerValue;
	}
	
	private Properties getHibernateProperties() {
		
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		prop.setProperty("hiberante.show_sql", env.getProperty("hibernate.show_sql"));
		return prop;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSourceConfig());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
}
