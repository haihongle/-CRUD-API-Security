package com.example.apiseuritypostman.service;

import com.example.apiseuritypostman.dao.EmployeeRepository;
import com.example.apiseuritypostman.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        return employeeRepository.findById(id)
                .map(existingEmployee -> {
                    existingEmployee.setName(employee.getName());
                    existingEmployee.setAge(employee.getAge());
                    existingEmployee.setEmail(employee.getEmail());
                    return employeeRepository.save(existingEmployee);
                })
                .orElse(null); // nếu không tìm thấy thì trả null
    }


    @Override
    public boolean deleteEmployee(Long id) {
        if (id != null && employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}