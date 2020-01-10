package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.repository")
@PropertySource("classpath:database.properties")
public class DataConfig {
	private final String PROPERTY_DRIVER = "driver";
	private final String PROPERTY_URL = "url";
	private final String PROPERTY_USERNAME = "user";
	private final String PROPERTY_PASSWORD = "password";
	private final String PROPERTY_DIALECT = "hibernate.dialect";
	private final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
	private final String PROPERTY_FORMAT_SQL = "hibernate.format_sql";

	@Autowired
	Environment environment;

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
		lfb.setDataSource(dataSource());
		lfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		lfb.setPackagesToScan("com.entities");
		lfb.setJpaProperties(hibernatePros());
		return lfb;
	}

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty(PROPERTY_DRIVER));
		dataSource.setUrl(environment.getProperty(PROPERTY_URL));
		dataSource.setUsername(environment.getProperty(PROPERTY_USERNAME));
		dataSource.setPassword(environment.getProperty(PROPERTY_PASSWORD));
		return dataSource;
	}

	Properties hibernatePros() {
		Properties properties = new Properties();
		properties.setProperty(PROPERTY_DIALECT, environment.getProperty(PROPERTY_DIALECT));
		properties.setProperty(PROPERTY_SHOW_SQL, environment.getProperty(PROPERTY_SHOW_SQL));
		properties.setProperty(PROPERTY_FORMAT_SQL, environment.getProperty(PROPERTY_FORMAT_SQL));
		return properties;
	}

	@Bean
	JpaTransactionManager transactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return jpaTransactionManager;
	}
}
