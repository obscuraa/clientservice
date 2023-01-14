package com.example.clientservice.mapper;

import com.example.clientservice.model.Shoes;
import com.example.clientservice.model.dto.ShoesAddDto;
import com.example.clientservice.model.dto.ShoesFullDto;
import org.springframework.stereotype.Component;

@Component
public class ShoesMapper {
    public Shoes addDtoToEntity(ShoesAddDto shoesAddDto) {
        return Shoes.builder()
                .name(shoesAddDto.getName())
                .shoesType(shoesAddDto.getShoesType())
                .build();
    }

    public ShoesFullDto toFullDto(Shoes shoes) {
        return ShoesFullDto.builder()
                .id(shoes.getId())
                .name(shoes.getName())
                .shoesType(shoes.getShoesType())
                .clientId(shoes.getClient().getId())
                .build();
    }
}
