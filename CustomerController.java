package com.vikash.customerDataManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vikash.customerDataManagement.dto.CustomerDto;
import com.vikash.customerDataManagement.dto.ResponseStructure;
import com.vikash.customerDataManagement.entites.Customer;
import com.vikash.customerDataManagement.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// 1 save
	@PostMapping("customers")
	public ResponseStructure<Customer> savaCustomerData(@RequestBody CustomerDto customerDto) {
		return customerService.saveCustomer(customerDto);
	}

	// 2 update
	@PutMapping("/customers")
	public ResponseStructure<Customer> updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}

	// 3 delete
	@DeleteMapping("/customers")
	public ResponseStructure<Customer> deleteCustomerById(@RequestParam("id") Integer id) {
		return customerService.deleteCustomerById(id);
	}

	// 4 getAll
	@GetMapping("/customers")
	public ResponseStructure<List<Customer>> getAllCustomerDetails() {
		return customerService.getAllCustomerData();
	}

	// 5 get by id
	@GetMapping("/customers/{id}")
	public ResponseStructure<Customer> findCustomerById(@PathVariable Integer id) {
		return customerService.getCustomerDataById(id);
	}
	
	// 6 get customer by name
	@GetMapping("/customersbyname/{name}")
	public ResponseStructure<List<Customer>> findCustomerByName( @PathVariable String name)
	{
		 return customerService.getCustomerByName(name);
	}
	// 7 
	@PostMapping("/validate")
	public ResponseStructure<List<Customer>> validateCustomer(@RequestParam("name") String name
			,@RequestParam("email")String email
			,@RequestParam("address")String address) {
		
		return customerService.validateCustomer(name, email, address);
		
	}
}
