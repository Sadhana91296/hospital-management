package com.example.SpringTest.Handler;

import com.example.SpringTest.request.Employee2Request;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
@Table(name="employees2")
public class Employee2 {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String Name;
        @JoinColumn(name="department_id")
        @OneToOne
        private Department department;
        public Employee2(Employee2Request req)
        {
        this.Name=req.getName();
        }

}
