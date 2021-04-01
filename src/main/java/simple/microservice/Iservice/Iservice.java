package simple.microservice.Iservice;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.simplerService.bean.Employee;

public interface Iservice {

	public List<Employee> getEmployeeList()throws JsonMappingException, JsonProcessingException;
	public Employee getEmployeeByEmpId(int id)throws JsonMappingException, JsonProcessingException;
}
