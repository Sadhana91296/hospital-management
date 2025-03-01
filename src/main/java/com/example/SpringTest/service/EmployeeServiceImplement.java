package com.example.SpringTest.service;

import com.example.SpringTest.Handler.Employee;
import com.example.SpringTest.Repositiry.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImplement implements EmployeeService{
    @Autowired
   private EmployeeRepository eRepository;

    @Override
    public List<Employee> getEmployee() {

        return eRepository.findAll();
    }
    @Override
    public Employee saveEmployee(Employee employee) {
        return eRepository.save(employee);
    }
}
