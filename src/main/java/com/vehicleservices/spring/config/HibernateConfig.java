package com.vehicleservices.spring.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:hibernate.config.properties")
public class HibernateConfig {
	
   // @Autowired
    //private ApplicationContext context;
    @Autowired
    private Environment environment;
   /* @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
        factoryBean.setAnnotatedClasses(User.class);
        factoryBean.setPackagesToScan("com.vehicleservices.spring.model");

        //factoryBean.setAnnotatedPackages("com.vehicleservices.spring.model");
        
        return factoryBean;
    }*/
    
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        //LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        //factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
        //factoryBean.setAnnotatedClasses(User.class);
        //factoryBean.setPackagesToScan("com.vehicleservices.spring.model");

        //factoryBean.setAnnotatedPackages("com.vehicleservices.spring.model");
        
      LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
  	  sessionFactoryBean.setDataSource(dataSource());
  	  sessionFactoryBean.setPackagesToScan(new String[] { "com.vehicleservices.spring.model" });
  	  sessionFactoryBean.setHibernateProperties(hibernateProperties());
  	  
  	  return sessionFactoryBean;
        
        
    }
 
    /*@Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
    */
    
    @Bean
	 public DataSource dataSource(){
	  DriverManagerDataSource ds = new DriverManagerDataSource();
	  ds.setDriverClassName(environment.getProperty("hibernate.connection.driver_class"));
	  ds.setUrl(environment.getProperty("hibernate.connection.url"));
	  ds.setUsername(environment.getProperty("hibernate.connection.username"));
	  ds.setPassword(environment.getProperty("hibernate.connection.password"));
	  
	  return ds;
	 }
    
	 private Properties hibernateProperties(){
		  Properties properties = new Properties();
		  properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		  properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		  properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
		  properties.put("hibernate.archive.autodetection", environment.getProperty("hibernate.archive.autodetection"));
		  return properties;
		 }
		 
	 
	 @Bean
	 @Autowired
	 public HibernateTransactionManager transactionManager(SessionFactory s){
	  HibernateTransactionManager txManager = new HibernateTransactionManager();
	  txManager.setSessionFactory(s);
	  return txManager;
	 }


    
    
}