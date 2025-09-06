package com.example.apiseuritypostman.service;

import com.example.apiseuritypostman.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    boolean deleteEmployee(Long id);
    List<Employee> getAllEmployees();
}
