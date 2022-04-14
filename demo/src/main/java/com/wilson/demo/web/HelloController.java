package com.wilson.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * a controller is basically something that routes requests and a web application
 * 
 * 
 * */
@RestController
@RequestMapping("/greeting") 
public class HelloController {
	/*
	 * call this to your browser localhost:8080/greeting/basic. you know that 'greeting' is controller level and 'basic' is a method level 
	 * */
	@RequestMapping(value = "/basic", method = RequestMethod.GET) //@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String sayHello() {
		return "<h1>hello</h1>";
	}
}
