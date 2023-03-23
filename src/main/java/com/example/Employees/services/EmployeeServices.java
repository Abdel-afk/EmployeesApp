package com.example.Employees.services;

import com.example.Employees.models.Employee;
import com.example.Employees.repositories.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {

    @Autowired
    IEmployeeRepository employeeInMemoryRepository;

    public List<Employee> getEmployees() {
        return this.employeeInMemoryRepository.findAll();
    }

    public Employee getById( int id) {
        return this.employeeInMemoryRepository.findById(id);
    }

    public Employee deleteEmployee( int id) {
        return this.employeeInMemoryRepository.deleteById(id);
    }

    public ResponseEntity<Employee> updateEmployee(int id,  Employee updatedEmployee) {
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
    public void save(Employee employee){
        employeeInMemoryRepository.save(employee);
    }
}
