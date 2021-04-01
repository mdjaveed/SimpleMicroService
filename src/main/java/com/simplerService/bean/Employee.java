package com.simplerService.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(value = Include.NON_EMPTY)
public class Employee {

	
	public Employee(int empId, String firstName, String lastName) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int empId;
	public String firstName;
	public String lastName;
}
