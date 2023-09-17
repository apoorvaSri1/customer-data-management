package com.vikash.customerDataManagement.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CustomerDto implements Serializable {
	private Integer id;
	private String name;
	private String email;
	private String address;
}
