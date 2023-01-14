package com.example.clientservice.controller;

import com.example.clientservice.model.Client;
import com.example.clientservice.model.dto.ClientAddDto;
import com.example.clientservice.model.dto.ClientFullDto;
import com.example.clientservice.model.dto.ClientUpdateDto;
import com.example.clientservice.model.dto.FilterDto;
import com.example.clientservice.service.ClientService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping(path = "/all")
    public List<ClientFullDto> getClients() {
        return clientService.getClients();
    }

    @GetMapping(path = "/filter")
    public List<ClientFullDto> getClientsPageable(@RequestBody FilterDto filterDto) {
        return clientService.getClientsPageable(PageRequest.of(filterDto.getNumber(), filterDto.getSize()));
    }

    @GetMapping(path = "{clientId}")
    public Optional<Client> findById(@PathVariable("clientId") UUID clientID) {
        return clientService.findById(clientID);
    }

    ;

    @PostMapping
    public ClientFullDto addNewClient(@RequestBody ClientAddDto client) {
        return clientService.addNewClient(client);
    }

    @DeleteMapping(path = "{clientId}")
    public Boolean deleteClient(@PathVariable("clientId") UUID clientId) {
        return clientService.deleteClient(clientId);
    }

    @PutMapping(path = "{clientId}")
    public ClientFullDto updateClient(
        @PathVariable("clientId") UUID clientId,
        @RequestBody ClientUpdateDto clientUpdateDto) {
        return clientService.updateClient(clientId, clientUpdateDto);
    }
}
