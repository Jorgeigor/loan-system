package com.example.loan_system.entities;

import lombok.Data;


@Data
public class Loan {
    private LoanType type;
    private Integer interest_rate;
}
