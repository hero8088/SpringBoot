package com.example.spring;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {
	
	private static final String[] CLASSPATH_REDSOURCE_LOCATIONS= {"claaapath:/static/", "classpath:/public/", "classpath:/",
			"classpath:/resources/", "classpath:/META-INF/resources/", "classpath:/META-INF/resources/webjars/"};
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_REDSOURCE_LOCATIONS);
	}
}
