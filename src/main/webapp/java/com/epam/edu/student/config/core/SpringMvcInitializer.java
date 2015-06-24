package com.epam.edu.jtc.config.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.epam.edu.jtc.config.Config;

public class SpringMvcInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected final Class<?>[] getRootConfigClasses() {
		return new Class[] { Config.class };
	}

	@Override
	protected final Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected final String[] getServletMappings() {
		return new String[] { "/" };
	}

}
