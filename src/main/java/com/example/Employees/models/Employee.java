package com.example.Employees.models;


import java.util.UUID;

public class Employee {
    private UUID id;

    private String name;

    private String email;

    private String username;

    public Employee(String name, String email, String username){
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public Employee() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

