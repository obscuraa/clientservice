package com.example.clientservice.mapper;

import com.example.clientservice.model.Shoes;
import com.example.clientservice.model.dto.ShoesAddDto;
import com.example.clientservice.model.dto.ShoesFullDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoesMapper {
    Shoes addDtoToEntity(ShoesAddDto shoesAddDto);

    @Mapping(target = "clientId", source = "shoes.client.id")
    ShoesFullDto toFullDto(Shoes shoes);

    @Mapping(target = "clientId", source = "shoes.client.id")
    List<ShoesFullDto> listShoesFullDto(List<Shoes> shoes);
}
