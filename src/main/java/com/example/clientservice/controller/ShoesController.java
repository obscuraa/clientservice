package com.example.clientservice.controller;

import com.example.clientservice.model.dto.ShoesAddDto;
import com.example.clientservice.model.dto.ShoesFullDto;
import com.example.clientservice.model.dto.ShoesUpdateDto;
import com.example.clientservice.service.ShoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/shoes")
@RequiredArgsConstructor
public class ShoesController {

    private final ShoesService shoesService;

    @GetMapping
    public List<ShoesFullDto> getShoes() {
        return shoesService.getShoes();
    }

    @GetMapping(path = "/byshoesid/{shoesId}")
    public ShoesFullDto findById(@PathVariable("shoesId") UUID shoesID) {
        return shoesService.findById(shoesID);
    }

    @GetMapping(path = "/byclientid/{clientId}")
    public ShoesFullDto findByClientId(@PathVariable("clientId") UUID clientID) {
        return shoesService.findById(clientID);
    }

    @PostMapping
    public ShoesFullDto addNewShoes(@RequestBody ShoesAddDto shoes) {
        return shoesService.addNewShoes(shoes);
    }

    @DeleteMapping(path = "{shoesId}")
    public Boolean deleteShoes(@PathVariable("shoesId") UUID shoesId) {
        return shoesService.deleteShoes(shoesId);
    }

    @PutMapping(path = "{shoesId}")
    public ShoesFullDto updateShoes(
            @PathVariable("shoesId") UUID shoesId,
            @RequestBody ShoesUpdateDto shoesUpdateDto) {
        return shoesService.updateShoes(shoesId, shoesUpdateDto);
    }
}
