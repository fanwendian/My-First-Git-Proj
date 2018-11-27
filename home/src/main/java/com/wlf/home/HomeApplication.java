package com.wlf.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@ServletComponentScan
public class HomeApplication extends SpringBootServletInitializer implements WebApplicationInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HomeApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(HomeApplication.class, args);
	}
}
