package com.sda.gabrieltudosanu.hibernate;

import com.sda.gabrieltudosanu.hibernate.model.Account;
import com.sda.gabrieltudosanu.hibernate.model.Department;
import com.sda.gabrieltudosanu.hibernate.model.Employee;
import com.sda.gabrieltudosanu.hibernate.repository.DepartmentRepository;
import com.sda.gabrieltudosanu.hibernate.repository.EmployeeRepository;

import java.sql.Date;

public class HQL {

    public static void main(String[] args) {

        DepartmentRepository departmentRepository = new DepartmentRepository();
        Department department1 = new Department();
        department1.setName("Finance");
        departmentRepository.save(department1);

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
        employee1.setDepartment(department1);
        employeeRepository.save(employee1, account1);

        employeeRepository.findAllEmployeesFromDepartment("Finance").forEach(employee -> System.out.println(employee));
    }

}
