package com.example.loan_system.controller;

import com.example.loan_system.dtos.ClientRequestDTO;
import com.example.loan_system.dtos.ClientResponseDTO;
import com.example.loan_system.dtos.LoanResponseDTO;
import com.example.loan_system.services.ClientService;
import com.example.loan_system.services.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("api/v1/loan")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final LoanService loanService;

    @PostMapping("/user")
    public ResponseEntity<ClientResponseDTO> setProfileUser(@RequestBody ClientRequestDTO data, UriComponentsBuilder uriComponentsBuilder){
        ClientResponseDTO clientResponseDTO = this.clientService.registerCLientOnSystem(data);
        var uri = uriComponentsBuilder.path("/api/v1/loan/{id}/loan-options").buildAndExpand(clientResponseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(clientResponseDTO);
    }

    @GetMapping("/{id}/loan-options")
    public ResponseEntity<LoanResponseDTO> getLoanOptions(@PathVariable Long id){
        LoanResponseDTO response = loanService.getLoanOptions(id);
        return ResponseEntity.ok(response);
    }
}
