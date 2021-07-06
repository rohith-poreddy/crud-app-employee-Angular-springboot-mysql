package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.Employee_Repository;


@Service
@Transactional
public class Employee_service {
	
	@Autowired
	private Employee_Repository repo;
    
    public List<Employee> listAll() {
        return repo.findAll();
    }
     
    public void save(Employee employee) {
        repo.save(employee);
    }
     
    public Employee get(Long id) {
        return repo.findById(id).get();
    }
     
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
