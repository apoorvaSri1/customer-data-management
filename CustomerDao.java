package com.vikash.customerDataManagement.reposistroy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.vikash.customerDataManagement.entites.Customer;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerReposistory customerReposistory;

	// 1 save
	public Customer saveCustomer(Customer customer) {

		return customerReposistory.save(customer);
	}

	// 2 update
	public Customer updateCustomer(Customer customer) {
		return customerReposistory.save(customer);
	}

	// 3 delete
	public Customer deleteCustomerById(Integer id) {
		Customer customer = getCustomerDataById(id);
		if (customer.getId() != 404) {
			customerReposistory.deleteById(id);
		}
		return customer;
	}

	// 4 getAll
	public List<Customer> getAllCustomerData() {
		return customerReposistory.findAll();
	}

	// 5 getById
	public Customer getCustomerDataById(Integer id) {
		return customerReposistory.findById(id).orElse(new Customer(HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.name(), HttpStatus.NOT_FOUND.name(), HttpStatus.NOT_FOUND.name()));
	}

	// 6 getCustomer By name
	public List<Customer> getCustomerByName(String name) {
		return customerReposistory.findByName(name);
	}

	// 7
	public List<Customer> validateCustomer(String name, String email, String address) {
		return customerReposistory.validateCustomer(name, email, address);
	}

}
