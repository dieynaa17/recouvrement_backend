package com.sonatel.recouvrement.service;
import com.sonatel.recouvrement.model.Client;

import java.util.List;

public interface ClientService {
    Client createClient(Client client);
    Client updateClient(Long id, Client client);
    void deleteClient(Long id);
    Client getClientById(Long id); // ici on retourne directement Client
    List<Client> getAllClients();
    Client getClientByEmail(String email);
}

