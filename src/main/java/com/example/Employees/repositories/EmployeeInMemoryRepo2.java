package com.example.Employees.repositories;

import com.example.Employees.models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmployeeInMemoryRepo2 implements IEmployeeRepository{

    List<Employee> employeeList = new ArrayList<>(
            List.of(new Employee("badr", "badrkahouaji26@gmail.com", "badr151")
                    , new Employee("aneeb", "aneebch@gmail.com", "aneebch"),
                    new Employee("anish", "anish@gmail.com", "anish"))
    );

    @Override
    public List<Employee> findAll() {
        return this.employeeList;
    }

    @Override
    public Employee findById(UUID id) {
        return this.employeeList.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst().get();
    }

    @Override
    public Employee save(Employee employee) {
        this.employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee deleteById(UUID id) {
        var employee = this.employeeList.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst().get();
        this.employeeList.remove(employee);
        return employee;
    }

    @Override
    public Employee update(UUID id, Employee employee) {
        for (Employee item : this.employeeList){
            if (item.getId().equals(id)){
                item.setName(employee.getName());
                item.setUsername(employee.getUsername());
                item.setEmail(employee.getEmail());
                return item;
            }
        }
        return null;
    }
}
