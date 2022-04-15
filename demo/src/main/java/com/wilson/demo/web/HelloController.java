package com.wilson.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("/proper") // basic mapping selalu GET, tanpa kita harus mendefine GET
	public String sayProperHello() {
		return "<h1>Hello there, how are you?</h1>";
	}
	
	@RequestMapping("/user_entry")
	public String userForm() {
		return "<form action=\"/greeting/user_greeting\" method=\"POST\">\r\n"
				+ "  First name:<br>\r\n"
				+ "  <input type=\"text\" name=\"firstname\"><br>\r\n"
				+ "  Last name:<br>\r\n"
				+ "  <input type=\"text\" name=\"lastname\"><br><br>\r\n"
				+ "  <br><br>\r\n"
				+ "  <input type=\"submit\" value=\"Submit\">\r\n"
				+ "</form> ";
	}
	
	@RequestMapping(value="/user_greeting", method=RequestMethod.POST)
	public String printUserGreeting(@RequestParam String firstname, @RequestParam String lastname) {
		return "Hello there, " + firstname + " " + lastname;
	}
	// anotation @RequestParam --> utk param name di body form
	// anotation @PathVariable --> utk param name di body form
	
	@RequestMapping(value="/orders/{id}", method = RequestMethod.GET)
	public String getOrder(@PathVariable String id) {
		return "Order OD: " + id;
	}
	
	
}
