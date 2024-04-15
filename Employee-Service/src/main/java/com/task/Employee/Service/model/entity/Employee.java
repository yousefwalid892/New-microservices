package com.task.Employee.Service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "E-mail")
    private String email;
    @Column(name = "Age")
    private int age;
    @Column(name = "Workflow-id")
    private int workflow_id;
    @Enumerated(EnumType.STRING)
    private Role role;
}
