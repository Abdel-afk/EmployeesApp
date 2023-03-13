package com.example.Employees.controller;

import com.example.Employees.models.Employee;
import com.example.Employees.repositories.EmployeeInMemoryRepository;
import com.example.Employees.repositories.IEmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeController {



    private final IEmployeeRepository employeeInMemoryRepository;

    public EmployeeController(IEmployeeRepository employeeInMemoryRepository) {
        this.employeeInMemoryRepository = employeeInMemoryRepository;
    } // Ineccion de dependencias por constructor


    List<Employee> employeeList = new ArrayList<>(
            List.of(new Employee("badr", "badrkahouaji26@gmail.com", "badr151")
                    , new Employee("aneeb", "aneebch@gmail.com", "aneebch"))
    );

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.employeeInMemoryRepository.findAll();
    }


    @GetMapping("/{id}")
    public Employee getById(@PathVariable UUID id) {
        return this.employeeInMemoryRepository.findById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeInMemoryRepository.save(employee);
    }

    @DeleteMapping("{id}")
    public Employee deleteEmployee(@PathVariable UUID id) {
        return this.employeeInMemoryRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Employee updateById(@PathVariable UUID id, @RequestBody Employee employee) {
        return this.employeeInMemoryRepository.update(id, employee);
    }

}

