package com.example.SpringTest.service;

import com.example.SpringTest.Handler.Employee;
import com.example.SpringTest.Repositiry.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee=eRepository.findById(id);
        if(employee.isPresent())
            return employee.get();
        throw new RuntimeException("Employee is not found by id "+id);


    }

    @Override
    public void deleteEmployee(Long id) {
        eRepository.deleteById(id);
    }
}
