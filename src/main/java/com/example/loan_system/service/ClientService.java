package com.example.loan_system.service;

import com.example.loan_system.dtos.ClientRequestDTO;
import com.example.loan_system.dtos.ClientResponseDTO;
import com.example.loan_system.entities.Client;
import com.example.loan_system.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientResponseDTO registerCLientOnSystem(ClientRequestDTO clientRequestDTO){
        Client client = new Client();
        client.setName(clientRequestDTO.name());
        client.setAge(clientRequestDTO.age());
        client.setCpf(clientRequestDTO.cpf());
        client.setIncome(clientRequestDTO.income());
        client.setLocation(clientRequestDTO.location());

        this.clientRepository.save(client);
        return new ClientResponseDTO(client);
    }
}
