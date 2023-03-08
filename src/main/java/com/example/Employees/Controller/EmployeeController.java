package com.example.Employees.Controller;

import com.example.Employees.models.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Api")
@CrossOrigin("*")
public class EmployeeController {

    List<Employee> employeeList = new ArrayList<>(
            List.of(new Employee("badr", "badrkahouaji26@gmail.com", "badr151")
                    , new Employee("aneeb", "aneebch@gmail.com", "aneebch"))
    );


    @GetMapping
    public String employee() {
        System.out.println("good");
        return "ok";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.employeeList;
    }

    ;


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



}

