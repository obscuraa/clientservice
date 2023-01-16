package com.example.clientservice.mapper;

import com.example.clientservice.model.Client;
import com.example.clientservice.model.dto.ClientAddDto;
import com.example.clientservice.model.dto.ClientFullDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ShoesMapper.class})
public interface ClientMapper {
    Client addDtoToEntity(ClientAddDto clientAddDto);

    @Mapping(target = "shoes", source = "client.shoes")
    ClientFullDto toFullDto(Client client);
}
