package com.simplerService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.simplerService.bean.Employee;

import simple.microservice.Iservice.Iservice;
@Service
@Component
public class ServiceImpl implements Iservice {

	String employeeList = "[{ \"empId\": 1, \"firstName\": \"MD\", \"lastName\": \"JAVEED\" },"
			+ "{ \"empId\": 12, \"firstName\": \"MhomD\", \"\": \"JAVEED\" },"
			+ "{ \"empId\": 13, \"firstName\": \"MD\", \"lastName\": \"JAVEED\" }]";
	
	@Autowired
	Gson gson;
	
	@Autowired
	ObjectMapper mapper;
	
	@Override
	public List<Employee> getEmployeeList() throws JsonMappingException, JsonProcessingException {
		return mapper.readValue(employeeList, new TypeReference<List<Employee>>(){} );
	}

	@Override
	public Employee getEmployeeByEmpId(int id) throws JsonMappingException, JsonProcessingException {
		List<Employee> list =	mapper.readValue(employeeList, new TypeReference<List<Employee>>(){} );
		Employee employee= list.stream().filter(emp -> emp.empId == id).findAny().orElse(null);
		return employee;
	}

}
