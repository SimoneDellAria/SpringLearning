package it.mycompany.springsecurity.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "it.mycompany.springsecurity")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfiguration implements WebMvcConfigurer{
	
	@Autowired
	private Environment env;

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }
	
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
	
}
