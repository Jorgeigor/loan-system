package com.example.loan_system.entities;

public enum LoanType {
    PERSONAL(4),
    GUARANTEED(3),
    CONSIGMENT(2);

    private final Integer interest_rate;

    LoanType(Integer interestRate) {
        interest_rate = interestRate;
    }

    public Integer getInterest_rate(){
        return interest_rate;
    }
}
