package com.example.Employees.controller;

import com.example.Employees.models.Employee;
import com.example.Employees.repositories.IEmployeeRepository;
import com.example.Employees.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeController {

    @GetMapping("/test")
    public String test () {
        return "check";
    }
@Autowired
    IEmployeeRepository employeeInMemoryRepository;

    @Autowired
    EmployeeServices employeeServices;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.employeeServices.getEmployees();
    }


    @GetMapping("/employees/{id}")
    public Employee getById(@PathVariable int id) {
        return this.employeeServices.getById(id);
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable int id) {
        return this.employeeServices.deleteEmployee(id);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        return this.employeeServices.updateEmployee(id,updatedEmployee);
        }
    @PostMapping("/employees")
    public void save(@RequestBody Employee employee){
        employeeServices.save(employee);
    }
}