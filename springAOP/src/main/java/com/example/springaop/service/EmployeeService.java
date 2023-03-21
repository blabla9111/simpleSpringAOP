package com.example.springaop.service;

import com.example.springaop.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.LinkedList;

public interface EmployeeService {
    ResponseEntity<Employee> getEmployeeById(String id);

    ResponseEntity<Employee> saveEmployee(Employee employee);

    ResponseEntity<LinkedList<Employee>> getAllEmployee();
}
