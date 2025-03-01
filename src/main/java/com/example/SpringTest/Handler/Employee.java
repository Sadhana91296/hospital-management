package com.example.SpringTest.Handler;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Getter
@Setter
@ToString
@Entity
@Table(name="employees")
public class Employee {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employeeNumber")
    private Long employeeNumber;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="extension")
    private String extension;
    @Column(name="officeCode")
    private String officeCode;
    @Column(name="Age")
    private Long age;
    @Column(name="reportsTo")
    private Long reportsTo;
    @Column(name="jobTitle")
    private String jobTitle;
    @Column(name="Location")
    private String location;
    @Column(name="email")
    private String email;
    @Column(name="Department")
    private String department;
}
