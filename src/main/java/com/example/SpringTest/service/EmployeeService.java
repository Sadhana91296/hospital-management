package com.example.SpringTest.service;

import com.example.SpringTest.Handler.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployee(int pageNumber,int PageSize);
    List<Employee> getEmployeeAll();
    Employee saveEmployee(Employee employee);
    Employee getSingleEmployee(Long id);
    void deleteEmployee(Long id);
     Employee updateEmployee(Employee employee);
    List<Employee> getEmployeesByFirstName(String firstName);
    List<Employee> getEmployeeByFirstNameAndLocation(String firstName, String location);
    List<Employee> getEmployeeByFirstNameContaining(String keyword);
}
