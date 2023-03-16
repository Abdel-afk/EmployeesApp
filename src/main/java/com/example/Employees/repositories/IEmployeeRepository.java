package com.example.Employees.repositories;

import com.example.Employees.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.UUID;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    Employee deleteById(int id);

    //Employee update(int id, Employee employee);
}
