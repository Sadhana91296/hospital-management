package com.example.SpringTest.service;

import com.example.SpringTest.Handler.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImplement implements EmployeeService{
    private static List<Employee> list=new ArrayList<>();
    static{
        Employee e=new Employee();
        e.setName("Sadhana");
        e.setAge(18l);
        e.setDepartment("IT");
        e.setEmail("abc@gmail.com");
        e.setLocation("India");
        list.add(e);

        e=new Employee();
        e.setName("Mona");
        e.setAge(19l);
        e.setDepartment("HR");
        e.setEmail("xyz@gmail.com");
        e.setLocation("India");
        list.add(e);

        e=new Employee();
        e.setName("Sona");
        e.setAge(20L);
        e.setDepartment("RMG");
        e.setEmail("nbc@gmail.com");
        e.setLocation("India");
        list.add(e);
    }
    @Override
    public List<Employee> getEmployee() {
        return list;
    }
}
