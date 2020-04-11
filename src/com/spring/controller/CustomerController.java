/**
 * Gagandeep
 * 12:11:17 am
 * 06-Apr-2020
 */
package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dao.CustomerDao;
import com.spring.entity.Customer;
import com.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/**
	 * Autowire will look for dependencies
	 * It will find an impelemntation with @Repository as an omplementation and will provide it here
	 */
	@Autowired
	private CustomerService service;
	
	@RequestMapping("/list")
//	@GetMapping("/list")	// new annoation in spring 4.3 (replace @RequestMapping(path="abc", method=RequestMethod.GET))
	public String listCustomer(Model model) {
		List<Customer> customers = service.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@RequestMapping("/addCustomer")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-customer";
	}
	
	@RequestMapping("/saveCustomer")
//	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		service.addCustomer(customer);
		return "redirect:/customer/list";	//will call method listCustomer
	}
	
	// http://localhost:8083/spring-mvc-customer-tracker/customer/showFormForUpdate?customerId=1
	@GetMapping("/showFormForUpdate")
	public String showUpdateForm(@RequestParam("customerId")int id, Model model) {
		Customer customer = service.fetchCustomer(id);
		model.addAttribute("customer", customer);
		return "add-customer";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@ModelAttribute("customerId") int id) {
		service.deleteCustomer(id);
		return "redirect:/customer/list";
	}

}
