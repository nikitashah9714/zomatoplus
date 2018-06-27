package com.thinkxfactor.zomatoplus.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication    //starting point of the application
@ComponentScan("com.thinkxfactor")      //scans for all the components/beans of a given package
@EnableJpaRepositories(basePackages = "com.thinkxfactor")   //basepackage means reference 
@EntityScan("com.thinkxfactor")   //scan for our entities all the objects classes etc under @entity annotation
public class ZomatoplusApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ZomatoplusApplication.class);
		//calls it with the class name
	}
	
	
}
