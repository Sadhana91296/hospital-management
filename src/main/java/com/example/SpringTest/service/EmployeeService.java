package com.example.SpringTest.service;

import com.example.SpringTest.Handler.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployee();
    Employee saveEmployee(Employee employee);
}
