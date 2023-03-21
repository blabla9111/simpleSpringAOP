package com.example.springaop.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;


public class Employee {
    private static LinkedList<Employee> employees = new LinkedList<>();

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    public Employee(){
        this.id = employees.size();
    }

    public Employee(String name) {
        this.id = employees.size();
        this.name = name;
    }

    public static Employee add(Employee employee) {
        System.out.println(employee.id+" "+employee.name);
        employees.add(employee);
        return employee;
    }

    public static Employee get(Integer id){
        return employees.get(id);
    }

    public static LinkedList<Employee> getAll(){
        return employees;
    }

}
