package com.example.Employees.controller;

import com.example.Employees.models.Employee;
import com.example.Employees.repositories.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeController {


    private final EmployeeRepository employeeRepository = new EmployeeRepository();

    List<Employee> employeeList = new ArrayList<>(
            List.of(new Employee("badr", "badrkahouaji26@gmail.com", "badr151")
                    , new Employee("aneeb", "aneebch@gmail.com", "aneebch"))
    );


    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.employeeRepository.findAll();
    }


    @GetMapping("/{id}")
    public Employee getById(@PathVariable UUID id) {
        return this.employeeRepository.findById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @DeleteMapping("{id}")
    public Employee deleteEmployee(@PathVariable UUID id) {
        return this.employeeRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Employee updateById(@PathVariable UUID id, @RequestBody Employee employee) {
        return this.employeeRepository.update(id, employee);
    }

}

