package com.example.SpringTest.Repositiry;

import com.example.SpringTest.Handler.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
