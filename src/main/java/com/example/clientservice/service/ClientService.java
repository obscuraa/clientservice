package com.example.clientservice.service;

import com.example.clientservice.model.dto.ClientAddDto;
import com.example.clientservice.model.dto.ClientFullDto;
import com.example.clientservice.model.dto.ClientUpdateDto;
import java.util.List;
import java.util.UUID;

public interface ClientService {

    List<ClientFullDto> getClients();

    ClientFullDto addNewClient(ClientAddDto clientAddDto);

    Boolean deleteClient(UUID clientId);

    ClientFullDto updateClient(UUID clientId, ClientUpdateDto clientUpdateDto);
}
