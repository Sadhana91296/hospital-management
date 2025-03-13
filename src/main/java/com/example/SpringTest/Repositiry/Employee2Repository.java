package com.example.SpringTest.Repositiry;

import com.example.SpringTest.Handler.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee2Repository extends PagingAndSortingRepository<Employee2,Long>, JpaRepository<Employee2,Long> {
}
