package com.example.clientservice.service.impl;

import com.example.clientservice.mapper.ShoesMapper;
import com.example.clientservice.model.Client;
import com.example.clientservice.model.Shoes;
import com.example.clientservice.model.dto.ClientFullDto;
import com.example.clientservice.model.dto.ShoesAddDto;
import com.example.clientservice.model.dto.ShoesFullDto;
import com.example.clientservice.model.dto.ShoesUpdateDto;
import com.example.clientservice.repository.ShoesRepository;
import com.example.clientservice.service.ClientService;
import com.example.clientservice.service.ShoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShoesServiceImpl implements ShoesService {
    private final ClientService clientService;
    private final ShoesRepository shoesRepository;
    private final ShoesMapper shoesMapper;

    @Override
    public List<ShoesFullDto> getShoes() {
        return shoesRepository.findAll()
                .stream()
                .map(shoesMapper::toFullDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShoesFullDto findById(UUID shoesID) {
        return shoesRepository.findById(shoesID).map(shoesMapper::toFullDto).orElse(null);
    }

    public ShoesFullDto findByClientId(UUID clientId) {
        return shoesRepository.findByClientId(clientId).map(shoesMapper::toFullDto).orElseThrow(null);
    }

    public ShoesFullDto addNewShoes(ShoesAddDto shoesAddDto) {
        Shoes shoes = shoesMapper.addDtoToEntity(shoesAddDto);
        var client = clientService.findById(shoesAddDto.getClientId());
        shoes.setClient(client);
        var result = shoesRepository.save(shoes);
        return shoesMapper.toFullDto(result);
    }

    @Override
    public Boolean deleteShoes(UUID shoesId) {
        if (!shoesRepository.existsById(shoesId)) {
            throw new IllegalStateException("shoes id " + shoesId + "does not exist");
        }
        shoesRepository.deleteById(shoesId);
        return true;
    }

    @Override
    public ShoesFullDto updateShoes(UUID shoesId, ShoesUpdateDto shoesUpdateDto) {
        var optionalShoes = shoesRepository.findById(shoesId);
        if (optionalShoes.isEmpty()) {
            return null;
        }
        var shoes = optionalShoes.get();
        shoes.setName(shoesUpdateDto.getName() == null ? shoes.getName() : shoesUpdateDto.getName());
        var result = shoesRepository.save(shoes);
        return shoesMapper.toFullDto(result);
    }
}
