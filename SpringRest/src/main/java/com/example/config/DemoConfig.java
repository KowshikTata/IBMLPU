package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.example")
public class DemoConfig implements WebMvcConfigurer{

	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver iviewResolver=new InternalResourceViewResolver();
		iviewResolver.setViewClass(JstlView.class);
		iviewResolver.setPrefix("/WEB-INF/pages/");
		iviewResolver.setSuffix(".jsp");
		return iviewResolver;
	}
	
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	
}
