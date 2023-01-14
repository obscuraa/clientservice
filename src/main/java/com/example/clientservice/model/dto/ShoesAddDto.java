package com.example.clientservice.model.dto;

import com.example.clientservice.model.Client;
import com.example.clientservice.model.ShoesType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoesAddDto {
    private String name;
    private ShoesType shoesType;
    private UUID clientId;
}
