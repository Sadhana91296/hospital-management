package com.example.SpringTest.service;

import com.example.SpringTest.Handler.Employee;
import com.example.SpringTest.Repositiry.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplement implements EmployeeService{
    @Autowired
   private EmployeeRepository eRepository;

    @Override
    public List<Employee> getEmployee(int pageNumber,int pageSize) {
        Pageable pages= PageRequest.of(pageNumber,pageSize);

        return eRepository.findAll(pages).getContent();
    }

    @Override
    public List<Employee> getEmployeeAll() {
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

    @Override
    public List<Employee> getEmployeesByFirstName(String firstName) {
        return eRepository.findByFirstName(firstName);
    }

    @Override
    public List<Employee> getEmployeeByFirstNameAndLocation(String firstName, String location) {
        return eRepository.findByFirstNameAndLocation(firstName, location);
    }

    @Override
    public List<Employee> getEmployeeByFirstNameContaining(String keyword) {
        return eRepository.findByFirstNameContaining(keyword);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
    }
}
