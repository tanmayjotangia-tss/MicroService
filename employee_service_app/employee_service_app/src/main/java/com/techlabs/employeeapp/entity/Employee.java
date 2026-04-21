package com.techlabs.employeeapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long employeeId;
    @Column
    public String name;
    @Column
    public Double salary;
    @Column
    public Long departmentId;
}
