package com.example.springaop.service.impl;

import com.example.springaop.entity.Employee;
import com.example.springaop.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public ResponseEntity<Employee> getEmployeeById(String id) {
        return ResponseEntity.ok().body(Employee.get(Integer.parseInt(id)));
    }

    @Override
    public ResponseEntity<Employee> saveEmployee(Employee employee) {
        System.out.println("!!!!!!!!!!!!!1111");
        return ResponseEntity.ok().body(Employee.add(employee));
    }

    @Override
    public ResponseEntity<LinkedList<Employee>> getAllEmployee() {
        return ResponseEntity.ok().body(Employee.getAll());
    }
}
