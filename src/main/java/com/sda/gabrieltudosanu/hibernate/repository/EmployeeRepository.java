package com.sda.gabrieltudosanu.hibernate.repository;

import com.sda.gabrieltudosanu.hibernate.model.Employee;
import com.sda.gabrieltudosanu.hibernate.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeRepository
{
    public Employee findById(Integer id)
    {
        Session session = SessionManager.getSessionFactory().openSession();
        //The find method returns the object with the provided id
        Employee employee = session.find(Employee.class, id);
        session.close();
        return employee;
    }
    public void save(Employee employee)
    {
        Session session= SessionManager.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }
    //TODO delete & update
}

