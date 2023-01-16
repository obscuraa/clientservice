package com.example.clientservice.service;

import com.example.clientservice.model.Client;
import com.example.clientservice.model.dto.ClientAddDto;
import com.example.clientservice.model.dto.ClientUpdateDto;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Pageable;

public interface ClientService {

    List<Client> getClients();

    List<Client> getClientsPageable(Pageable pageable);

    Client findById(UUID clientID);

    Client addNewClient(ClientAddDto clientAddDto);

    Boolean deleteClient(UUID clientId);

    Client updateClient(UUID clientId, ClientUpdateDto clientUpdateDto);
}
