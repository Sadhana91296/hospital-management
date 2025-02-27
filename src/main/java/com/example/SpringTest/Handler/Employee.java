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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employeeNumber")
    private Long employeeNumber;
    @Column(name="firstName")
    private String name;
    @Column(name="age")
    private Long age;
    @Column(name="Location")
    private String location;
    @Column(name="Email")
    private String email;
    @Column(name="Department")
    private String department;
}
