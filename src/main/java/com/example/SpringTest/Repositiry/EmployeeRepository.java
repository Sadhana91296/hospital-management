package com.example.SpringTest.Repositiry;

import com.example.SpringTest.Handler.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>, JpaRepository<Employee,Long> {
    List<Employee> findByFirstName(String firstName);
    //Select * from employee where firstName="Sadhana" AND location="Bangalore" below Methos JPA convert as this query

    List<Employee> findByFirstNameAndLocation(String firstName,String location);
    //select * from employee where firstName Like "%dha%";

    List<Employee> findByFirstNameContaining(String keyword, Sort sort);
    @Query("From Employee where firstName=:firstName OR location=:location")
    List<Employee> getEmployeeByNameAndLocation(String firstName,String location);
    @Transactional
    @Modifying
    @Query("Delete from Employee where firstName=:firstName")
    Integer deleteEmployeeByName(String firstName);
}
