package com.example.loan_system.entities;

public enum TypeLoan {
    PERSONAL(4),
    GUARANTEED(3),
    CONSIGMENT(2);

    private final Integer interest_rate;

    TypeLoan(Integer interestRate) {
        interest_rate = interestRate;
    }

    public Integer getInterest_rate(){
        return interest_rate;
    }
}
