package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeservice;

	@PostMapping("/employee")
	public Map<String, Object> insertEmpDetails(@RequestBody Employee employee) {
		return employeeservice.insertEmployeeDetails(employee);
	}

	@PutMapping("/employee")
	public Map<String, Object> updateEmpDetails(@RequestBody Employee employee) {
		return employeeservice.updateEmployeeDetails(employee);
	}

	@DeleteMapping("/employee/{id}")
	public Map<String, Object> deleteEmpDetails(@PathVariable int id) {
		return employeeservice.deleteEmployeeDetails(id);
	}

	@GetMapping("/employee/{id}")
	public List<Map<String, Object>> getEmpIdBy(@PathVariable int id, @RequestParam String name) {
		return employeeservice.getEmployeeById(id, name);
	}
	
	@GetMapping("/employee/{id}")
	public List<Map<String, Object>> getEmpIdByRequestParam(@PathVariable int id, @RequestParam int age) {
		return employeeservice.getEmployeeById(id, age);
	}

}