package com.example.clientservice.service;

import com.example.clientservice.model.Client;
import com.example.clientservice.model.dto.ClientAddDto;
import com.example.clientservice.model.dto.ClientFullDto;
import com.example.clientservice.model.dto.ClientUpdateDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {

    List<ClientFullDto> getClients();

    List<ClientFullDto> getClientsPageable(Pageable pageable);

    ClientFullDto findById(UUID clientID);

    ClientFullDto addNewClient(ClientAddDto clientAddDto);

    Boolean deleteClient(UUID clientId);

    ClientFullDto updateClient(UUID clientId, ClientUpdateDto clientUpdateDto);
}
