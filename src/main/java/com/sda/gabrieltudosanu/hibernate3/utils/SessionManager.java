package com.sda.gabrieltudosanu.hibernate3.utils;

import com.sda.gabrieltudosanu.hibernate3.model.Client;
import com.sda.gabrieltudosanu.hibernate3.model.Reservation;
import com.sda.gabrieltudosanu.hibernate3.model.Seat;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager extends AbstractSessionManager {

    private static final SessionManager INSTANCE = new SessionManager();

    private SessionManager() {
    }

    public static void shutDown() {
        INSTANCE.shutdownSessionManager();
    }

    public static SessionFactory getSessionFactory() {
        return INSTANCE.getSessionFactory("CinemaSDA");
    }

    @Override
    protected void setAnnotatedClasses(Configuration configuration) {

        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Reservation.class);
        configuration.addAnnotatedClass(Seat.class);

    //TODO de trecut clasele din acest proiect

    }

}
