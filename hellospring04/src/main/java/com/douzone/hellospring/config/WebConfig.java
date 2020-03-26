package com.douzone.hellospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// 제작순서 1

// 설정파일은 최대한 configuration을 넣어주는 것이 좋다!
@Configuration
// EnableWebMvc이 있어야 웹에 필요한 콘테이너 안의 핸들러맵핑 리졸버 등을 다 만들어준다.
@EnableWebMvc
@ComponentScan({"com.douzone.hellospring.controller"})
public class WebConfig {
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		// setExposeContextBeansAsAttributes 컨테이너를 관리할 때 사용하는 메소드
		resolver.setExposeContextBeansAsAttributes(true);
		
		return resolver;
	}
}
