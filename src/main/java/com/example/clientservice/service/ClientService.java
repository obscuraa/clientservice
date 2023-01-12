package com.example.clientservice.service;

import com.example.clientservice.model.Client;
import com.example.clientservice.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @GetMapping
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client addNewClient(Client client) {
        Optional<Client> clientByOptional = clientRepository.findClientByEmail(client.getEmail());
        if (clientByOptional.isPresent()){
            throw new IllegalStateException("email is already taken");
        }
        //System.out.println(client);
        return clientRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        boolean exists = clientRepository.existsById(clientId);
        if (!exists) {
            throw new IllegalStateException("client id " + clientId + "does not exist");
        }
        clientRepository.deleteById(clientId);
    }

    @Transactional
    public Client updateClient(Long clientId, String name, String email) {
        Client client = clientRepository.findById(clientId).orElseThrow(
                () -> new IllegalStateException("client with id " + clientId + "does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(client.getName(), name)) {
            client.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(client.getEmail(), email)) {
            Optional<Client> clientOptional = clientRepository.findClientByEmail(email);
            if (clientOptional.isPresent()){
                throw new IllegalStateException("email is already taken");
            }
            client.setEmail(email);
        }
    }
}
