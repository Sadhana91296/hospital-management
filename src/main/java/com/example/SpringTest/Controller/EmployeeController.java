package com.example.SpringTest.Controller;

import com.example.SpringTest.Handler.Department;
import com.example.SpringTest.Handler.Employee;
import com.example.SpringTest.Handler.Employee2;
import com.example.SpringTest.Repositiry.DepartmentRepository;
import com.example.SpringTest.Repositiry.Employee2Repository;
import com.example.SpringTest.request.Employee2Request;
import com.example.SpringTest.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private DepartmentRepository dRepo;
    @Autowired
    private Employee2Repository e2Repo;
    @GetMapping("employee/All")
    public List<Employee> getEmployee()
    {
        return eService.getEmployeeAll();
    }
    @GetMapping("/employees")
    public ResponseEntity<List<Employee >> getEmployee(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        return new ResponseEntity<>(eService.getEmployee(pageNumber,pageSize), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id){

        return new ResponseEntity<>(eService.getSingleEmployee(id),HttpStatus.OK);
    }
    //localhost:8080//employees?id=12
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployeeByParam(@RequestParam("id") Long id)
    {

        eService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee)
    {

        return new ResponseEntity<>(eService.saveEmployee(employee),HttpStatus.CREATED);
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
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee){
            employee.setEmployeeNumber(id);
             return new ResponseEntity<>(eService.updateEmployee(employee),HttpStatus.OK);

    }
    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeeByFirstName(@RequestParam String firstName)
    {
        return new ResponseEntity<>(eService.getEmployeesByFirstName(firstName),HttpStatus.OK);
    }
    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeeByFirstNameAndLocation(@RequestParam String firstName,@RequestParam String location)
    {
        return new ResponseEntity<>(eService.getEmployeeByFirstNameAndLocation(firstName,location), HttpStatus.OK);
    }
    @GetMapping("/employees/filterByNameKeyword")
    public ResponseEntity<List<Employee>> getEmployeeByFirstNameKeyword(@RequestParam String keyword)
    {
        return new ResponseEntity<>(eService.getEmployeeByFirstNameContaining(keyword), HttpStatus.OK);
    }
    @GetMapping("/employees/{firstName}/{location}")
    public ResponseEntity<List<Employee>> getEmployeeByNameAndLocation(@PathVariable String firstName,@PathVariable String location)
    {
        return new ResponseEntity<>(eService.getEmployeeByNameAndLocation(firstName,location), HttpStatus.OK);
    }
    @DeleteMapping("/employees/delete/{firstName}")
    public ResponseEntity<String> getEmployeeByNameAndLocation(@PathVariable String firstName)
    {
        return new ResponseEntity<>(eService.deleteByEmployeeName(firstName)+" number of employee affected", HttpStatus.OK);
    }

    @PostMapping("/employees2")
    public ResponseEntity<Employee2> saveEmployee(@Valid @RequestBody Employee2Request eRequest)
    {
        Department dept=new Department();
        dept.setName(eRequest.getDepartment());
        dept=dRepo.save(dept);

        Employee2 employee2=new Employee2(eRequest);
        employee2.setDepartment(dept);

        employee2=e2Repo.save(employee2);
        return new ResponseEntity<Employee2>(employee2,HttpStatus.CREATED);
    }
}
