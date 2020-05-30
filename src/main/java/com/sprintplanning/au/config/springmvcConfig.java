package com.sprintplanning.au.config;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({"com.sprintplanning.au"})
public class springmvcConfig extends WebMvcConfigurerAdapter {


	@Bean(name = "filterMultipartResolver")
	public CommonsMultipartResolver multiPartResolver(){
	    CommonsMultipartResolver resolver = new 
	    CommonsMultipartResolver();
	    return resolver;
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver canBeCalledAnything(){
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		return resolver;
	}
	

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setContentType("text/html");
        viewResolver.setPrefix("/view/");
        return viewResolver;
    }

}
