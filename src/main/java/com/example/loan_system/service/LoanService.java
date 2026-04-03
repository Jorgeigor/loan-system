package com.example.loan_system.service;


import com.example.loan_system.dtos.LoanItemDTO;
import com.example.loan_system.dtos.LoanResponseDTO;
import com.example.loan_system.entities.Client;
import com.example.loan_system.entities.TypeLoan;
import com.example.loan_system.execptions.LoanDefaultIncome;
import com.example.loan_system.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final ClientRepository clientRepository;

    public LoanResponseDTO getLoanOptions(Long id){

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        BigDecimal income = client.getIncome();
        String location = client.getLocation();
        Integer age = client.getAge();

        List<LoanItemDTO> loanOptionsAprove = new ArrayList<>();

        boolean isIncomeUp5000 = income.compareTo(new BigDecimal("5000")) <= 0;
        boolean isIncomeOver5000 = income.compareTo(new BigDecimal("5000")) > 0;
        boolean isIncomeDefault = income.compareTo(new BigDecimal("500")) < 0;
        boolean locationIsSP = location.compareTo(new String("SP")) == 0;

        if(isIncomeUp5000 && !isIncomeDefault) {
            loanOptionsAprove.add(new LoanItemDTO(TypeLoan.PERSONAL.name(), TypeLoan.PERSONAL.getInterest_rate()));
        }
        if(isIncomeOver5000){
            loanOptionsAprove.add(new LoanItemDTO(TypeLoan.CONSIGMENT.name(), TypeLoan.CONSIGMENT.getInterest_rate()));
        }
        if (locationIsSP && age.compareTo(30) <= 0){
            loanOptionsAprove.add(new LoanItemDTO(TypeLoan.GUARANTEED.name(), TypeLoan.GUARANTEED.getInterest_rate()));
        }
        if(loanOptionsAprove.isEmpty()) {
            throw new LoanDefaultIncome("Sem emprestimos por enquanto");
        }

        return new LoanResponseDTO(client.getName(), loanOptionsAprove);
    }
}
