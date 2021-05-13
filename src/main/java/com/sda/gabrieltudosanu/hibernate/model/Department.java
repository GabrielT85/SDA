package com.sda.gabrieltudosanu.hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments") // mandatory - singular vs plural.

public class Department {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // optional - identical names
    private Integer id;
    @Column(name = "name") // optional - identical names
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}