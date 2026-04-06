package com.example.loan_system.config;

import com.example.loan_system.exceptions.ClientAlreadyExistsException;
import com.example.loan_system.exceptions.NoEligibleLoansException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(NoEligibleLoansException.class)
    public ResponseEntity handleIncomeDefault(NoEligibleLoansException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
    @ExceptionHandler(ClientAlreadyExistsException.class)
    public ResponseEntity handleClientAlreadyExists(ClientAlreadyExistsException clientAlreadyExistsException){
        return ResponseEntity.badRequest().body(clientAlreadyExistsException.getMessage());
    }
}
