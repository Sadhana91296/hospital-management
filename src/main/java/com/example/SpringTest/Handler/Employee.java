package com.example.SpringTest.Handler;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name="employees")
public class Employee {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employeeNumber")
    @NonNull
    private Long employeeNumber;
    @NotNull(message = "First name should not be null")
    private String firstName;

    private String lastName;

    private String extension;

    private String officeCode;

    private Long age=0L;

    private Long reportsTo;

    private String jobTitle;

    private String location;
    @Email(message = "Enter valid email")
    private String email;

    private String department;
    @Column(name="createdAt", nullable=false, updatable=false)
    @CreationTimestamp
    private Date createdAt;
    @Column(name="updatedAt")
    @UpdateTimestamp
    private Date updatedAt;
}
