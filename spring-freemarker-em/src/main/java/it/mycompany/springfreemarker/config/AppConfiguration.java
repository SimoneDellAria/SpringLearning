package it.mycompany.springfreemarker.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import it.mycompany.springfreemarker.dao.ProductDAO;
import it.mycompany.springfreemarker.dao.ProductDAOImpl;

@EnableWebMvc
@Configuration
@ComponentScan("it.mycompany.springfreemarker")
@PropertySource("classpath:persistence-mysql.properties")
@EnableTransactionManagement
public class AppConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public FreeMarkerViewResolver configureResolver() {
		FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
		viewResolver.setPrefix("");
		viewResolver.setSuffix(".ftl");
		return viewResolver;
	}

	@Bean
	public FreeMarkerConfigurer configureFreeMarker() {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPath("/WEB-INF/view/");
		return configurer;
	}

	@Bean
	public DataSource dataSourceConfig() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl(env.getProperty("jdbc.url"));
		datasource.setUsername(env.getProperty("jdbc.user"));
		datasource.setPassword(env.getProperty("jdbc.password"));
		datasource.setDriverClassName(env.getProperty("jdbc.driver"));
		return datasource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerConfig() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSourceConfig());
		factory.setJpaVendorAdapter(adapter);
		factory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		factory.setJpaProperties(getHibernateProperties());
		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionMAnagerConfig() {
		JpaTransactionManager transaction = new JpaTransactionManager(entityManagerConfig().getObject());
		return transaction;
	}

	private Properties getHibernateProperties() {

		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		prop.setProperty("hiberante.show_sql", env.getProperty("hibernate.show_sql"));
		return prop;
	}

	@Bean
	public ProductDAO getProductDAO() {
		return new ProductDAOImpl();
	}
}
