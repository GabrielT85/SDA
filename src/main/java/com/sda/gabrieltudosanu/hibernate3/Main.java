package com.sda.gabrieltudosanu.hibernate3;

import com.sda.gabrieltudosanu.hibernate3.model.Client;
import com.sda.gabrieltudosanu.hibernate3.repository.ClientRepository;
import com.sda.gabrieltudosanu.hibernate3.utils.SessionManager;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {
        ClientRepository clientRepository = new ClientRepository();

        Client client1 = new Client("Ion","Ionescu","ion@ionescu.com", Date.valueOf("1980-10-30"));
        Client client2 = new Client("Vasi","Loiu","vasi@loiu.com", Date.valueOf("1990-12-25"));
        clientRepository.save(client1);
        clientRepository.save(client2);

        ClientRepository.findAll().forEach(client -> System.out.println(client));

        SessionManager.shutDown();
    }
}
