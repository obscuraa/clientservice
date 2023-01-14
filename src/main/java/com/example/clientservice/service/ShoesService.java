package com.example.clientservice.service;

import com.example.clientservice.model.Shoes;
import com.example.clientservice.model.dto.ShoesAddDto;
import com.example.clientservice.model.dto.ShoesFullDto;
import com.example.clientservice.model.dto.ShoesUpdateDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShoesService {
    List<ShoesFullDto> getShoes();

    ShoesFullDto findById(UUID shoesId);

    ShoesFullDto findByClientId(UUID clientId);

    ShoesFullDto addNewShoes(ShoesAddDto shoesAddDto);

    Boolean deleteShoes(UUID clientId);

    ShoesFullDto updateShoes(UUID clientId, ShoesUpdateDto shoesUpdateDto);
}
