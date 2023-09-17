package com.vikash.customerDataManagement.reposistroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vikash.customerDataManagement.entites.Customer;

public interface CustomerReposistory  extends JpaRepository<Customer, Integer>{

	List<Customer> findByName(String name);
	
	@Query("SELECT c FROM Customer c WHERE c.name=:name AND c.email=:email AND c.address=:address")
	List<Customer> validateCustomer(@Param("name") String name
			,@Param("email")String email
			,@Param("address")String address);
	
}
