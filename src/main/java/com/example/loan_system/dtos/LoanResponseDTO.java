package com.example.loan_system.dtos;



import java.util.List;

public record LoanResponseDTO(String name, List<LoanItemDTO> loanOptions) {
}
