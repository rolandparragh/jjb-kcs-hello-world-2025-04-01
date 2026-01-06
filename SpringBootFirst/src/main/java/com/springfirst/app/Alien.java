package com.springfirst.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {
	
	@Autowired
	Laptop laptop; 
	// The Alien class is a Spring component. The @Autowired annotation tells Spring to automatically
	// inject a Laptop bean into the laptop field when creating an Alien object. This is called dependency injection.
	// When the code() method is called, it uses the injected Laptop to call its compile() method.

	
	public void code() {
		
		laptop.compile();
		
		
	}

}
