package it.mycompany.springfreemarker.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import it.mycompany.springfreemarker.dao.ProductDAO;
import it.mycompany.springfreemarker.dao.ProductDAOImpl;

@EnableWebMvc
@Configuration
@ComponentScan("it.mycompany.springfreemarker")
@PropertySource("classpath:persistence-mysql.properties")
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
	public DataSource dataSourceConfig(){
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl(env.getProperty("jdbc.url"));
		datasource.setUsername(env.getProperty("jdbc.user"));
		datasource.setPassword(env.getProperty("jdbc.password"));
		datasource.setDriverClassName(env.getProperty("jdbc.driver"));
		
		return datasource;
	}
	
	
	@Bean
	public ProductDAO getProductDAO() {
		return new ProductDAOImpl(dataSourceConfig());
	}
}
