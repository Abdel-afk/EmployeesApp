package com.example.Employees.repositories;

import com.example.Employees.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    List<Employee> employeeList = new ArrayList<>(
            List.of(new Employee("badr", "badrkahouaji26@gmail.com", "badr151")
                    , new Employee("aneeb", "aneebch@gmail.com", "aneebch"),
                    new Employee("anish", "anish@gmail.com", "anish"))
    );

    public List<Employee> findAll() {
        return this.employeeList;
    }
}
