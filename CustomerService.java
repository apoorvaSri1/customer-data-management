package com.vikash.customerDataManagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vikash.customerDataManagement.dto.CustomerDto;
import com.vikash.customerDataManagement.dto.ResponseStructure;
import com.vikash.customerDataManagement.entites.Customer;
import com.vikash.customerDataManagement.reposistroy.CustomerDao;

@Service
public class CustomerService {
	
	
	@Autowired
	private CustomerDao customerDao;
	
	
	//1 save
	public ResponseStructure<Customer> saveCustomer(CustomerDto dto)
	{
		Customer cus = new Customer(dto);
		 Customer customer = customerDao.saveCustomer(cus);
		 ResponseStructure<Customer> rs = new ResponseStructure<>();
		 rs.setData(customer);
		 rs.setStatusCode(HttpStatus.OK.value());
		 rs.setMessage("Customer data saved successfully");
		 rs.setTimeStamp(LocalDateTime.now());
		 return rs;
	}
	
	
	// 2 update
	public ResponseStructure<Customer> updateCustomer(Customer customer) {
		Customer cus = customerDao.updateCustomer(customer);
		 ResponseStructure<Customer> rs = new ResponseStructure<>();
		 rs.setData(cus);
		 rs.setStatusCode(HttpStatus.ACCEPTED.value());
		 rs.setTimeStamp(LocalDateTime.now());
		 rs.setMessage(HttpStatus.ACCEPTED.name());
		 return rs;
	}
	
	// 3 delete 
	public ResponseStructure<Customer> deleteCustomerById(Integer id)
	{
		 Customer cust = customerDao.deleteCustomerById(id);
		 ResponseStructure<Customer> rs = new ResponseStructure<>();
		 if(cust.getId()!=404) {
			 rs.setStatusCode(HttpStatus.FOUND.value());
			 rs.setMessage("Customer Deleted successfully");
			 rs.setTimeStamp(LocalDateTime.now());
			 rs.setData(cust);
		 }else
		 {
			 rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			 rs.setMessage("Customer Not found So not deleted successfully");
			 rs.setTimeStamp(LocalDateTime.now());
			 rs.setData(cust); 
		 }
		 return rs;
	}
	
	
	
	// 4 getById
	public ResponseStructure<Customer> getCustomerDataById(Integer id)
	{
		 Customer cust = customerDao.deleteCustomerById(id);
		 ResponseStructure<Customer> rs = new ResponseStructure<>();
		 if(cust.getId()!=404) {
			 rs.setStatusCode(HttpStatus.FOUND.value());
			 rs.setMessage("Customer Found");
			 rs.setTimeStamp(LocalDateTime.now());
			 rs.setData(cust);
		 }else
		 {
			 rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			 rs.setMessage("Customer Not found ");
			 rs.setTimeStamp(LocalDateTime.now());
			 rs.setData(cust); 
		 }
		 return rs;
	}
	
	// 5 getAll
	public ResponseStructure<List<Customer>> getAllCustomerData()
	{
		  List<Customer> list = customerDao.getAllCustomerData();
		  ResponseStructure<List<Customer>> rs = new ResponseStructure<>();
		  if(list.size()!=0) {
			  rs.setData(list);
			  rs.setTimeStamp(LocalDateTime.now());
			  rs.setStatusCode(HttpStatus.FOUND.value());
			  rs.setMessage("customer entry found in database");
		  }
		  else {
			  rs.setData(list);
			  rs.setTimeStamp(LocalDateTime.now());
			  rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			  rs.setMessage("customer entry Not found in database");
		  }
		  return rs;
	}
	
	
	
	
	
	// 6 get customer by name
	public ResponseStructure<List<Customer>> getCustomerByName( String name)
	{
		  List<Customer> list = customerDao.getCustomerByName(name);
		  ResponseStructure<List<Customer>> rs = new ResponseStructure<>();
		  if(list.size()!=0) {
			  rs.setData(list);
			  rs.setTimeStamp(LocalDateTime.now());
			  rs.setStatusCode(HttpStatus.FOUND.value());
			  rs.setMessage("customer entry found in database");
		  }
		  else {
			  rs.setData(list);
			  rs.setTimeStamp(LocalDateTime.now());
			  rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			  rs.setMessage("customer entry Not found in database");
		  }
		  return rs;
	}
	// 7 
	public ResponseStructure<List<Customer>> validateCustomer(String name,String email,String address)
	{
		  List<Customer> list = customerDao.validateCustomer(name, email, address);
		  ResponseStructure<List<Customer>> rs = new ResponseStructure<>();
		  if(list.size()!=0) {
			  rs.setData(list);
			  rs.setTimeStamp(LocalDateTime.now());
			  rs.setStatusCode(HttpStatus.FOUND.value());
			  rs.setMessage("customer entry found in database");
		  }
		  else {
			  rs.setData(list);
			  rs.setTimeStamp(LocalDateTime.now());
			  rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			  rs.setMessage("customer entry Not found in database");
		  }
		  return rs;
	}
	
}
