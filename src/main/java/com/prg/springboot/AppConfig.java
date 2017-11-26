package com.prg.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*@SpringBootApplication
 public class HelloWorld {
 public static void main(String[] args) {
 SpringApplication.run(HelloWorld.class, args);
 }

 }*/
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class AppConfig extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

	// Kinds of replacement for web.xml configuration
	// Will be invoked at the time of app configuration of server
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AppConfig.class);
	}

}
