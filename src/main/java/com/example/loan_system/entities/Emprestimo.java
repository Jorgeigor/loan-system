package com.example.loan_system.entities;

import lombok.Data;


@Data
public class Emprestimo {
    private TypeLoan type;
    private Integer interest_rate;
}
