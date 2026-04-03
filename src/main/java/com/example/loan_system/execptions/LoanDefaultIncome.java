package com.example.loan_system.execptions;

public class LoanDefaultIncome extends RuntimeException {
    public LoanDefaultIncome(String message) {
        super(message);
    }
}
