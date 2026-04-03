package com.example.loan_system.config;

import com.example.loan_system.execptions.LoanDefaultIncome;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionEnityHandler {
    @ExceptionHandler(LoanDefaultIncome.class)
    public ResponseEntity handleIncomeDefault(LoanDefaultIncome exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
