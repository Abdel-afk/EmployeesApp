package com.example.Employees.controller;

import com.example.Employees.models.Employee;
//import com.example.Employees.repositories.EmployeeInMemoryRepository;
import com.example.Employees.repositories.IEmployeeRepository;
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
    private final IEmployeeRepository employeeInMemoryRepository;

    public EmployeeController(IEmployeeRepository employeeInMemoryRepository) {
        this.employeeInMemoryRepository = employeeInMemoryRepository;
    } // Ineccion de dependencias por constructor


    /*List<Employee> employeeList = new ArrayList<>(
            List.of(new Employee("badr", "badrkahouaji26@gmail.com", "badr151")
                    , new Employee("aneeb", "aneebch@gmail.com", "aneebch"))
    );*/

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.employeeInMemoryRepository.findAll();
    }


    @GetMapping("/employees/{id}")
    public Employee getById(@PathVariable int id) {
        return this.employeeInMemoryRepository.findById(id);
    }

   /* @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeInMemoryRepository.save(employee);
    }*/

    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable int id) {
        return this.employeeInMemoryRepository.deleteById(id);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = Optional.ofNullable(employeeInMemoryRepository.findById(id));

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            employee.setName(updatedEmployee.getName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setUsername(updatedEmployee.getUsername());

            employeeInMemoryRepository.save(employee);

            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();}
        }
    @PostMapping("/employees")
    public void save(@RequestBody Employee employee){
        employeeInMemoryRepository.save(employee);
    }
}