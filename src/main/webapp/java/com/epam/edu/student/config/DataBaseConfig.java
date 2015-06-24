package com.epam.edu.jtc.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:dataSource.properties" })
public class DataBaseConfig implements TransactionManagementConfigurer {
	protected static final Logger LOG = Logger.getLogger(DataBaseConfig.class);

	@Autowired
	private Environment env;

	@Bean(name = "sessionFactory")
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(
				dataSource());
		builder.scanPackages("com.epam.edu.jtc.model").addProperties(
				getHibernateProperties());
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties props = new Properties();
		String propFileName = "connectionDB.properties";
		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream(propFileName);
		try {
			props.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			LOG.error(e);
		}
		return props;
	}

	@Bean
	public HibernateTransactionManager txManager() {
		return new HibernateTransactionManager(sessionFactory());
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("DriverClassName"));
		dataSource.setUrl(env.getProperty("Url"));
		dataSource.setUsername(env.getProperty("Username"));
		return dataSource;
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return txManager();
	}

}
