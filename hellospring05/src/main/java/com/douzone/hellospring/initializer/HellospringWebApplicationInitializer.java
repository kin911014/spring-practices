package com.douzone.hellospring.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.douzone.hellospring.config.WebConfig;

public class HellospringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// 이자리에 AppConfig를 넣어주면 된다
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// Root Application Context 설정
		return null;
	}

	// 이자리에 WebConfig를 넣어주면 된다
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Web Application Context 설정
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// Servlet mapping 설정
		return new String[] {"/"};
	}

}
