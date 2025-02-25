package com.example.SpringTest.Controller;

import com.example.SpringTest.Handler.Employee;
import com.example.SpringTest.service.EmployeeService;
import com.example.SpringTest.service.EmployeeServiceImplement;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller + @ResponseBody or only @RestController
@RestController
@RequestMapping()
public class EmployeeController {
    //@RequestMapping(value="/employees", method= RequestMethod.GET)
    //@ResponseBody
//autoconfigure object
    @Autowired
    private EmployeeService eService;
    @GetMapping("/employees")
    public List<Employee > getEmployee(){
        return eService.getEmployee();
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
