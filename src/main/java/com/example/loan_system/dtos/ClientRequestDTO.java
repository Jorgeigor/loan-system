package com.example.loan_system.dtos;

import java.math.BigDecimal;

public record ClientRequestDTO(String name, String cpf, Integer age, BigDecimal income, String location) {
}
