package com.codoidTest2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codoidTest2.Codoid_employee.Employee;
import com.codoidTest2.service.employeeService;

@RestController
@RequestMapping("/api")
public class employeeController {
	
	@Autowired
	private employeeService employeeservice;
	
	@GetMapping("/listAll")
	public List<Employee> listAll(){
		return employeeservice.listAll();
	}
	
	@PostMapping("/addEmployee")
	public List<Employee> addByData(@RequestBody Employee employee) {
		employeeservice.addList(employee);
		return employeeservice.listAll();
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable(name="id") long id){
		return employeeservice.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public String Update(@PathVariable(name="id") long id,@RequestBody Employee employee) {
		return employeeservice.updateById(id,employee);
	}
	
	@PostMapping("/getById/{id}")
	public List<?> getById(@PathVariable(name ="id") long id){
		return employeeservice.getById(id);
	}
}
