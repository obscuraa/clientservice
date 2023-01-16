package com.example.clientservice.controller;

import com.example.clientservice.model.dto.ClientAddDto;
import com.example.clientservice.model.dto.ClientFullDto;
import com.example.clientservice.model.dto.ClientUpdateDto;
import com.example.clientservice.model.dto.FilterDto;
import com.example.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public ClientFullDto findById(@PathVariable("clientId") UUID clientID) {
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
