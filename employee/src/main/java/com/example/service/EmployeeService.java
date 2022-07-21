package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	JdbcTemplate jdbctemplate;

	public Map<String, Object> insertEmployeeDetails(Employee employee) {
		Map<String, Object> response = new HashMap();
 
		int id = employee.getEmpid();
		String name = employee.getEmpname();
		int age = employee.getEmpage();

		try {
			String insertQuery = "insert into employee values(?,?,?)";
			int result = jdbctemplate.update(insertQuery, id, name, age);
			if (result > 0)
				response.put("row", "inserted succesfully");
			else
				response.put("error occured", "during insertion");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public Map<String, Object> updateEmployeeDetails(Employee employee) {
		Map<String, Object> response = new HashMap();
		int id = employee.getEmpid();
		String name = employee.getEmpname();
		try {
			String updateQuery = "UPDATE employee set name=? WHERE id=?";
			int result = jdbctemplate.update(updateQuery, name, id);
			if (result > 0) {
				response.put("row", "updated successfully");
			} else {
				response.put("note", "Enter valid id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}

	public Map<String, Object> deleteEmployeeDetails(int id) {
		Map<String, Object> response = new HashMap<>();
		try {
			String deleteQuery = "Delete from employee where id=?";
			int result = jdbctemplate.update(deleteQuery, id);
			// int result = jdbctemplate.update("Delete from employee where id=" + id);

			if (result > 0) {
				response.put("row", "deleted successfully");
			} else {
				response.put("note", "no record available");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	public List<Map<String, Object>> getEmployeeById(int id, String name) {
		List<Map<String, Object>> response = new ArrayList<>();
		try {
			String selectQuery = "select * from employee where id=? and name=?";
			response = jdbctemplate.queryForList(selectQuery, id, name);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	public List<Map<String, Object>> getEmployeeById(int id, int age) {
		List<Map<String, Object>> response = new ArrayList<>();
		try {
			
			String selectQuery = "select * from employee where id=?";
			if (age > 0) {
				String ageQuery = " and age=?";
				selectQuery = selectQuery + ageQuery;
			}
			response = jdbctemplate.queryForList(selectQuery, id, age);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
}
