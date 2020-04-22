package com.example.config;

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
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@ComponentScan("com.example")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource({"classpath:db.properties"})
public class DemoConfig implements WebMvcConfigurer{

	@Autowired
	private Environment env;
	
	
	
	@Bean
	 DataSource myDataSource()
	{
		// create connection pool
				ComboPooledDataSource myDataSource = new ComboPooledDataSource();

				// set the jdbc driver
				try {
					myDataSource.setDriverClass("com.mysql.jdbc.Driver");		
				}
				catch (PropertyVetoException exc) {
					throw new RuntimeException(exc);
				}
				myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
				myDataSource.setUser(env.getProperty("jdbc.user"));
				myDataSource.setPassword(env.getProperty("jdbc.password"));
				
				myDataSource.setInitialPoolSize(getIntProperty(env.getProperty("connection.pool.initialPoolSize")));
				myDataSource.setMinPoolSize(getIntProperty(env.getProperty("connection.pool.minPoolSize")));
				myDataSource.setMaxPoolSize(getIntProperty(env.getProperty("connection.pool.maxPoolSize")));
				myDataSource.setMaxIdleTime(getIntProperty(env.getProperty("connection.pool.maxIdleTime")));
				
				return myDataSource;
	}

	private int getIntProperty(String property) {
		// TODO Auto-generated method stub
		return Integer.parseInt(property);
	}
	private Properties getHibernateProperties() {

		// set hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return props;				
	}
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		// create session factorys
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		// set the properties
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}	
	
	
}
	
			