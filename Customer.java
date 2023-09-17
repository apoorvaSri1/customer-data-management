package com.vikash.customerDataManagement.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vikash.customerDataManagement.dto.CustomerDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="customer_info")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String address;
	
	
	public Customer(CustomerDto dto) {
		this.id=dto.getId();
		this.name=dto.getName();
		this.email=dto.getEmail();
		this.address=dto.getAddress();
	}

}
