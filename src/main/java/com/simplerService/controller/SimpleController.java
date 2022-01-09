package com.simplerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.simplerService.bean.Employee;

import simple.microservice.Iservice.Iservice;

 
@RestController
public class SimpleController {
	
	@Autowired
	Iservice service;
	
	
	@GetMapping( value = "/viewEmployeeList" ,produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Employee>> employeeList() throws JsonMappingException, JsonProcessingException {
		return new ResponseEntity<List<Employee>>(service.getEmployeeList(), HttpStatus.OK);
	}
	@GetMapping( value = "/employee" ,produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> employeeById(@RequestParam(value = "id",required = true) int id ) throws JsonMappingException, JsonProcessingException {
		if(service.getEmployeeByEmpId(id)!=null) {
			return new ResponseEntity<Object>(service.getEmployeeByEmpId(id),HttpStatus.OK);
		}
		return new ResponseEntity<Object>("{\"error\" : \"Data Not Found for "+id+"\"}", HttpStatus.NOT_FOUND);
	}
}