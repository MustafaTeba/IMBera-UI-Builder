package com.imbera.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;


/*
 * The annotation below used to scan the servlet context loader added to the sf-java-ui library
 * in order to initialize the library @ server startup
 * 
 * */

@SpringBootApplication
@EntityScan("com.imbera.entity")
@ServletComponentScan(basePackages = { 
		"io.imbera.ui.core",
		"com.imbera.demo.executors",
		"com.imbera.demo.web",
		"com.imbera.demo.renderer"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
}