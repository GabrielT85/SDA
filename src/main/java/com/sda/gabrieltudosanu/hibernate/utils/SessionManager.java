package com.sda.gabrieltudosanu.hibernate.utils;

import com.sda.gabrieltudosanu.hibernate.model.Department;
import com.sda.gabrieltudosanu.hibernate.model.Employee;
import com.sda.gabrieltudosanu.hibernate.model.Project;
import com.sun.istack.internal.NotNull;
import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;

public class SessionManager extends AbstractSessionManager{

    private static final SessionManager INSTANCE= new SessionManager();

    private SessionManager() {
    }

    public static void shutDown(){
        INSTANCE.shutdownSessionManager();
    }

    public static SessionFactory getSessionFactory(){
        return INSTANCE.getSessionFactory("HumanResources");
    }

    @Override
    protected void setAnnotatedClasses(org.hibernate.cfg.Configuration configuration) {
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Project.class);
    }


}
