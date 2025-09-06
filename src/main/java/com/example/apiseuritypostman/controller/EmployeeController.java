package com.example.apiseuritypostman.controller;

import com.example.apiseuritypostman.entity.Employee;
import com.example.apiseuritypostman.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public String hi(){
        return "hi";
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteEmployee(@PathVariable  Long id){
        return employeeService.deleteEmployee(id);
    }
}