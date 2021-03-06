package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.Employee_service;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Employee_controller {

    @Autowired
    private Employee_service service;
    
    @GetMapping("/employee")
    public List<Employee> list() {
        return service.listAll();
    }
    
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> get(@PathVariable Long id) {
        try {
            Employee employee = service.get(id);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @PostMapping("/employee")
    public void add(@RequestBody Employee employee) {
        service.save(employee);
    }
    
    
    @PutMapping("/employee/{id}")
    public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Long id) {
        try {
           // Employee existemployee = service.get(id);
            service.save(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
