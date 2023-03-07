package com.example.Employees.Controller;

import com.example.Employees.models.Employee;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Api")
@CrossOrigin("*")
public class EmployeeController {

    List<Employee> employeeList = new ArrayList<>(
            List.of(new Employee("badr","badrkahouaji26@gmail.com","badr151")
            ,new Employee("aneeb","aneebch@gmail.com","aneebch")));
    @GetMapping("/employee")
    public String employee(){
        System.out.println("good");
        return "ok";
    };
}