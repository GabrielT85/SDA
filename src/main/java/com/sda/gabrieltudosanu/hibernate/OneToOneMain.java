package com.sda.gabrieltudosanu.hibernate;

import com.sda.gabrieltudosanu.hibernate.model.*;
import com.sda.gabrieltudosanu.hibernate.repository.DepartmentRepository;
import com.sda.gabrieltudosanu.hibernate.repository.EmployeeRepository;
import com.sda.gabrieltudosanu.hibernate.repository.ProjectRepository;
import com.sda.gabrieltudosanu.hibernate.utils.SessionManager;

import java.sql.Date;

public class OneToOneMain {

    public static void main(String[] args) {

        DepartmentRepository departmentRepository = new DepartmentRepository();

        Employee employee1 = new Employee();
        employee1.setFirstName("Mircea");
        employee1.setLastName("Popa");
        employee1.setEmail("jgfuf@yahoo.com");
        employee1.setDateOfBirth(Date.valueOf("1987-02-03"));
        employee1.setPhoneNumber("0744128986");
        employee1.setSalary(5000);
        Employee employee2 = new Employee();
        employee2.setFirstName("Vasile");
        employee2.setLastName("Vasilescu");
        employee2.setEmail("jgfuf@yahoo.com");
        employee2.setDateOfBirth(Date.valueOf("1950-02-03"));

        employee2.setPhoneNumber("0744654548");
        employee2.setSalary(12000);

        Account account1 = new Account();
        account1.setCreationDate(Date.valueOf("1995-09-23"));
        Account account2 = new Account();
        account2.setCreationDate(Date.valueOf("2000-10-29"));

        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.save(employee1, account1);
        employeeRepository.save(employee2, account2);

        System.out.println(employeeRepository.findById(1));
        System.out.println(employeeRepository.findById(2));

        SessionManager.shutDown();
    }
}
