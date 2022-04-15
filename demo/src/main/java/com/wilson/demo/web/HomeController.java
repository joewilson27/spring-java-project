package com.wilson.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wilson.demo.domain.User;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model) { // of you wanna retrieve or send data interact with UI, so use model
		model.addAttribute("formData", new User());
		// the key "formData" harus sama dgn th:object="${formData}" pada form di index.html
		
		return "index"; // this would be find an index page, because on this controller class
		// we use @Controller not RestController like the class we had earlier so then they're not return back
		// a string. And they would find the file index on src/main/resources/template
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String processFormData(User user, RedirectAttributes attr) {
		// Insert data submitted in the form to the database
		
		// object user akan di tangkap di page result.html
		//return "result";
		
		// redirect, remember, redirect dont transfer data, so we need RedirectAttributes
		attr.addFlashAttribute("user", user);
		return "redirect:/display"; // redirect (redirect don't transfer data)
	}
	
	@RequestMapping(value="/display", method=RequestMethod.GET)
	public String displayFormData(User user) {
		return "result";
	}
}
