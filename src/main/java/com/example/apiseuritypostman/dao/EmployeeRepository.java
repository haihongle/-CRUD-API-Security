package com.example.apiseuritypostman.dao;

import com.example.apiseuritypostman.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);

    Optional<Employee> findById(long id);

}
