package com.epam.edu.jtc.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import freemarker.template.Configuration;

@Component
@PropertySource({ "classpath:login.properties" })
public final class MailConfig {
	protected static final Logger LOG = Logger.getLogger(MailConfig.class);

	@Autowired
	private Environment env;

	@Autowired
	private ServletContext context;

	@Bean(name = "myTemplateConfiguration")
	public Configuration myTemplateConfiguration() {
		Configuration myTemplateConfiguration = new Configuration(
				Configuration.VERSION_2_3_22);
		myTemplateConfiguration.setServletContextForTemplateLoading(context,
				"/templates");
		return myTemplateConfiguration;
	}

	@Bean(name = "session")
	public Session session() {
		Properties props = new Properties();
		String propFileName = "mail.properties";

		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream(propFileName);
		try {
			props.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			LOG.error(e);
		}

		Session session = Session.getDefaultInstance(props,
				new Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(env
								.getProperty("mail.login"), env
								.getProperty("mail.password"));
					}
				});
		return session;
	}

}
