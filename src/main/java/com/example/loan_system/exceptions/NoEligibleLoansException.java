package com.example.loan_system.exceptions;

public class NoEligibleLoansException extends RuntimeException {
    public NoEligibleLoansException(String message) {
        super(message);
    }
}
