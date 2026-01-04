package com.springfirst.app;

import java.beans.JavaBean;
import org.springframework.context.ApplicationContext;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFirstApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(SpringBootFirstApplication.class, args);
		
		
		Alien alien = context.getBean(Alien.class);
		alien.code();
		
	}

}
