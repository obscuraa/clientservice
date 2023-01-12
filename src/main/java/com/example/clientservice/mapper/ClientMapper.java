package com.example.clientservice.mapper;

import com.example.clientservice.model.Client;
import com.example.clientservice.model.dto.ClientAddDto;
import com.example.clientservice.model.dto.ClientFullDto;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client addDtoToEntity(ClientAddDto clientAddDto) {
        return Client.builder()
            .age(clientAddDto.getAge())
            .email(clientAddDto.getEmail())
            .fullName(clientAddDto.getFullName())
            .build();
    }

    public ClientFullDto toFullDto(Client client) {
        return ClientFullDto.builder()
            .id(client.getId())
            .fullName(client.getFullName())
            .age(client.getAge())
            .email(client.getEmail())
            .build();
    }
}
