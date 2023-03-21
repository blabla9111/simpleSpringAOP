package com.example.springaop.controllers;

import com.example.springaop.entity.Employee;
import com.example.springaop.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService empoyeeService;

    public EmployeeController(EmployeeService empoyeeService) {
        this.empoyeeService = empoyeeService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id){
        return empoyeeService.getEmployeeById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return empoyeeService.saveEmployee(employee);
    }

    @GetMapping("/all")
    public ResponseEntity<LinkedList<Employee>> getAllEmployee(){
        return empoyeeService.getAllEmployee();
    }

}
