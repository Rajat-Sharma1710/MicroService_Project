package com.employee.demo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
    public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String contact;
        private String employer;

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {
        //
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmployer() {
        return employer;
    }
}
