package com.sda.gabrieltudosanu.hibernate;

import com.sda.gabrieltudosanu.hibernate.model.*;
import com.sda.gabrieltudosanu.hibernate.repository.DepartmentRepository;
import com.sda.gabrieltudosanu.hibernate.repository.EmployeeRepository;
import com.sda.gabrieltudosanu.hibernate.repository.ProjectRepository;
import com.sda.gabrieltudosanu.hibernate.utils.SessionManager;

import java.sql.Date;

public class NoRelationsMain {

    public static void main(String[] args) {

        DepartmentRepository departmentRepository = new DepartmentRepository();
        Department department1 = new Department();
        department1.setName("HR");
        departmentRepository.save(department1);

        Department department = departmentRepository.findById(1);
        System.out.println(department);

        department.setName("HRDepartment");
        departmentRepository.update(department);
        department = departmentRepository.findById(1);
        System.out.println(department);

        departmentRepository.delete(department);
        department = departmentRepository.findById(1);
        System.out.println(department);

        Department department2 = new Department();
        department2.setName("IT");
        departmentRepository.save(department2);

        Department department3 = departmentRepository.findById(3);
        System.out.println(department3);

        SessionManager.shutDown();
    }
}