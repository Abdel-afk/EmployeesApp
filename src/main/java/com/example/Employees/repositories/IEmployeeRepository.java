package com.example.Employees.repositories;

import com.example.Employees.models.Employee;

import java.util.List;
import java.util.UUID;

public interface IEmployeeRepository {
    List<Employee> findAll();

    Employee findById(UUID id);

    Employee save(Employee employee);

    Employee deleteById(UUID id);

    Employee update(UUID id, Employee employee);
}
