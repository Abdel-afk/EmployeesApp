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
    public ResponseEntity<Employee> getById(@PathVariable UUID id) {
        for (Employee employee : this.employeeList) {
            if (employee.getId().equals(id)) return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();

        //       var optionalEmployee = this.employeeList.stream()
        //               .filter(item -> item.getId().equals(id))
        //               .findFirst();
        //      if (optionalEmployee.isEmpty()) return ResponseEntity.notFound().build();
        //      return new ResponseEntity<>(optionalEmployee.get(), HttpStatus.OK);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        this.employeeList.add(employee);
        return employee;
    }

    @DeleteMapping("{id}")
    public Employee deleteEmployee(@PathVariable UUID id) {
        var employee = this.employeeList.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst().get();
        this.employeeList.remove(employee);
        return employee;
    }

    @PutMapping("{id}")
    public Employee updateById(@PathVariable UUID id, @RequestBody Employee employee) {

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

