package com.sda.gabrieltudosanu.hibernate3.repository;

import com.sda.gabrieltudosanu.hibernate3.model.Client;
import com.sda.gabrieltudosanu.hibernate3.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClientRepository {

    public Client findById(Integer Id) {
        Session session = SessionManager.getSessionFactory().openSession();
        Client client = session.find(Client.class, Id);
        //inainte sa returnam orice inchidem sesiunea
        session.close();
        return client;
    }

    public void save (Client client) {
        Session session = SessionManager.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit(); //i-am dat dreptul sa se persiste in baza de date
        session.close();
    }

    public static Set<Client> findAll(){
        Session session = SessionManager.getSessionFactory().openSession();
        //nu avem nevoie de tranzactie, daca nu facem update in baza de date
        List<Client> result = session.createQuery("select c from Client c").getResultList();
        session.close();
        return new HashSet<>(result);
    }
}
