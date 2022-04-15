package com.wilson.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wilson.demo.domain.Product;

@RestController
@RequestMapping("/user") 
public class UserController {
	
	@RequestMapping("/{userId}") 
	public String displayUser(@PathVariable int userId) {
		return "User Found: " + userId;
	}
	
	@RequestMapping("/{userId}/invoices") 
	public String displayUserInvoices(@PathVariable("userId") int userId,
			@RequestParam(value="date", required=false) Date dateOrNull) { //@RequestParam Date date) { <- old lecture
		// jika seperti di atas, kita menggunakan @RequestParam tp method ini menggunakan GET, maka 
		// @RequestParam adl query parameter: localhost:8080/user/7/invoices?date=12/22/2010
		
		// @RequestParam(value="date", required=false) adl cara utk membuat request menjadi tdk required
		// pada contoh disini, query string date kita buat sbg optional jika di panggil
		
		// @PathVariable also be customized like this @PathVariable("id")
		// jika kita menggunakan ini, make sure you create the same variable to your  
		// @RequestMapping("/{userId}/invoices") 
		
		return "Invoice found for user: " + userId + " on the date: " + dateOrNull;
	}
	
	@RequestMapping("/{userId}/items")
	public List<String> displayStringJson(){
		return Arrays.asList("Shoes", "laptop", "button");
	}
	
	@RequestMapping("/{userId}/products_as_json")
	public List<Product> displayProductsJson(){
		return Arrays.asList(new Product(1, "shoes", 42.99),
							 new Product(2, "books", 12.99),
							 new Product(3, "bag", 45.99));
	}
	
}
