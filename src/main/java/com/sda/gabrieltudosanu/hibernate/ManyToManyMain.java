package com.sda.gabrieltudosanu.hibernate;

import com.sda.gabrieltudosanu.hibernate.model.Account;
import com.sda.gabrieltudosanu.hibernate.model.Employee;
import com.sda.gabrieltudosanu.hibernate.model.Project;
import com.sda.gabrieltudosanu.hibernate.repository.EmployeeRepository;
import com.sda.gabrieltudosanu.hibernate.repository.ProjectRepository;
import com.sda.gabrieltudosanu.hibernate.utils.SessionManager;

import java.sql.Date;

public class ManyToManyMain {

    public static void main(String[] args) {

        ProjectRepository projectRepository = new ProjectRepository();

        Project project1 = new Project();
        project1.setName("ProjectX");
        projectRepository.save(project1);

        Project project2 = new Project();
        project2.setName("ProjectXX");
        projectRepository.save(project2);

        EmployeeRepository employeeRepository = new EmployeeRepository();

        Employee employee1 = new Employee();
        employee1.setFirstName("Mircea");
        employee1.setLastName("Popa");
        employee1.setEmail("jgfuf@yahoo.com");
        employee1.setDateOfBirth(Date.valueOf("1987-02-03"));
        employee1.setPhoneNumber("0744128986");
        employee1.setSalary(5000);
        Account account1 = new Account();
        account1.setCreationDate(Date.valueOf("1995-09-23"));
        employee1.getProjects().add(project1);
        employee1.getProjects().add(project2);
        employeeRepository.save(employee1, account1);

        Employee employee2 = new Employee();
        employee2.setFirstName("Vasile");
        employee2.setLastName("Vasilescu");
        employee2.setEmail("jgfuf@yahoo.com");
        employee2.setDateOfBirth(Date.valueOf("1950-02-03"));
        employee2.setPhoneNumber("0744654548");
        employee2.setSalary(12000);
        Account account2 = new Account();
        account2.setCreationDate(Date.valueOf("2000-10-29"));
        employee2.getProjects().add(project1);
        employeeRepository.save(employee2, account2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Ion");
        employee3.setLastName("Ionescu");
        employee3.setEmail("jgfuf@yahoo.com");
        employee3.setDateOfBirth(Date.valueOf("1959-03-04"));
        employee3.setPhoneNumber("074465425");
        employee3.setSalary(11000);
        Account account3 = new Account();
        account3.setCreationDate(Date.valueOf("2000-10-29"));
        employee3.getProjects().add(project1);
        employee3.getProjects().add(project2);
        employeeRepository.save(employee3, account3);

        // SessionManager.shutDown();
    }
}
