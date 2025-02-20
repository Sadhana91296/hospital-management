package com.example.SpringTest.Controller;

import com.example.SpringTest.Handler.Employee;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

//@Controller + @ResponseBody or only @RestController
@RestController
public class EmployeeController {
    //@RequestMapping(value="/employees", method= RequestMethod.GET)
    //@ResponseBody
    @GetMapping("/employees")
    public String getEmployee()
    {
        return "Display Employee List";
    }
    @GetMapping("/employees/{id}")
    public String getEmployee(@PathVariable("id") Long id){
        return "Fetching employee details "+id;
    }
    //localhost:8080//employees?id=12
    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestParam("id") Long id)
    {
        return "Deleting Record for employee with id "+id;
    }
    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee)
    {
        return "Saving the employee details to the database "+employee;
    }
    @org.springframework.beans.factory.annotation.Value("${app.version}")
    private String appVersion;
    @org.springframework.beans.factory.annotation.Value("${app.name}")
    private String appName;
    @GetMapping("/version")
    public String getAppDetails()
    {
        return appName+" - "+appVersion;
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee){
        System.out.println("Updating employee data");
        return employee;

    }

}
