package com.example.loan_system.dtos;

import com.example.loan_system.entities.Client;

import java.math.BigDecimal;

public record ClientResponseDTO(Long id, String name, String cpf, Integer age, BigDecimal income, String location) {
    public ClientResponseDTO(Client client){
        this(client.getId(), client.getName(), client.getCpf(), client.getAge(), client.getIncome(), client.getLocation());
    }

}
