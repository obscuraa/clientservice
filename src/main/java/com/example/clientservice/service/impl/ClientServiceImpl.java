package com.example.clientservice.service.impl;

import com.example.clientservice.mapper.ClientMapper;
import com.example.clientservice.model.dto.ClientAddDto;
import com.example.clientservice.model.dto.ClientFullDto;
import com.example.clientservice.model.dto.ClientUpdateDto;
import com.example.clientservice.repository.ClientRepository;
import com.example.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientFullDto> getClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toFullDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientFullDto> getClientsPageable(Pageable pag) {

        return clientRepository.findAll(pag)
                .stream()
                .map(clientMapper::toFullDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientFullDto findById(UUID clientID) {
        return clientRepository.findById(clientID).map(clientMapper::toFullDto).orElseThrow(null);
    }

    @Override
    public ClientFullDto addNewClient(ClientAddDto clientAddDto) {
        var result = clientRepository.save(clientMapper.addDtoToEntity(clientAddDto));
        return clientMapper.toFullDto(result);
    }

    @Override
    public Boolean deleteClient(UUID clientId) {
        if (!clientRepository.existsById(clientId)) {
            throw new IllegalStateException("client id " + clientId + "does not exist");
        }
        clientRepository.deleteById(clientId);
        return true;
    }

    @Override
    public ClientFullDto updateClient(UUID clientId, ClientUpdateDto clientUpdateDto) {
        var optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isEmpty()) {
            return null;
        }
        var client = optionalClient.get();
        client.setAge(clientUpdateDto.getAge() == null ? client.getAge() : clientUpdateDto.getAge());
        client.setFullName(clientUpdateDto.getFullName() == null ? client.getFullName() : clientUpdateDto.getFullName());
        client.setEmail(clientUpdateDto.getEmail() == null ? client.getEmail() : clientUpdateDto.getEmail());
        var result = clientRepository.save(client);
        return clientMapper.toFullDto(result);
    }
}

