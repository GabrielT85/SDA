package com.sda.gabrieltudosanu.hibernate.repository;

import com.sda.gabrieltudosanu.hibernate.model.Employee;
import com.sda.gabrieltudosanu.hibernate.utils.SessionManager;
import com.sda.gabrieltudosanu.hibernate.model.Account;
import com.sda.gabrieltudosanu.hibernate.model.Department;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeRepository {
    public Employee findById(Integer id)
    {
        Session session = SessionManager.getSessionFactory().openSession();
        //The find method returns the object with the provided id
        Employee employee = session.find(Employee.class, id);
        session.close();
        return employee;
    }
    public void save(Employee employee, Account account)
    {
        Session session= SessionManager.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.save(account);//am adaugat accountul in baza de date si se genereaza in ID pt account
        employee.setAccount(account);//setam accountul pe employee
        session.save(employee);//adaugam employee in baza de date
        transaction.commit();
        session.close();
    }

    public void delete(Employee employee){
        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
        session.close();
    }

    public void update(Employee employee){
        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(employee);
        transaction.commit();
        session.close();
    }

    public List<Employee> findAllEmployeesFromDepartment(String departmentName){
        Session session = SessionManager.getSessionFactory().openSession();
        String hqlquery = "from Employee e WHERE e.department.name = :departmentName";
        Query<Employee>employeeQuery = session.createQuery(hqlquery);
        employeeQuery.setParameter("departmentName", departmentName);
        List<Employee> employees = employeeQuery.list();
        session.close();
        return employees;
    }
}