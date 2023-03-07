package com.example.Employees.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Api")
@CrossOrigin("*")
public class EmployeeController {
    @GetMapping("/employee")
    public String employee(){
        System.out.println("good");
        return "ok";
    };
}