package com.example.springaop.service.impl;

import com.example.springaop.aop.ChangingArgs;
import com.example.springaop.aop.MyLogger;
import com.example.springaop.entity.Employee;
import com.example.springaop.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @MyLogger
    @Override
    public ResponseEntity<Employee> getEmployeeById(String id) {
        return ResponseEntity.ok().body(Employee.get(Integer.parseInt(id)));
    }

    @MyLogger
    @Override
    public ResponseEntity<Employee> saveEmployee(Employee employee) {
        return ResponseEntity.ok().body(Employee.add(employee));
    }

    @MyLogger
    @Override
    public ResponseEntity<LinkedList<Employee>> getAllEmployee() {
        return ResponseEntity.ok().body(Employee.getAll());
    }

    @MyLogger
    @ChangingArgs
    @Override
    public ResponseEntity<Employee> getMainEmployee(String id) {
        System.out.println("___Execution getMainEmployee() method___");
        System.out.println("id = "+id);
        return ResponseEntity.ok().body(Employee.get(Integer.parseInt(id)));
    }
}
