package com.profiler.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.profiler.profile.repository.ResourceRepository;
import com.profiler.profile.utility.ImageFileReader;

@SpringBootApplication
public class ProfileApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	ImageFileReader imageFileReader;
	
	@Autowired
	ResourceRepository resourceRepository;
	
	 @Override
	   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	      return application.sources(ProfileApplication.class);
	   }
	
	public static void main(String[] args) {
		SpringApplication.run(ProfileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		System.out.println("this runs!");
		
		
	}
}
