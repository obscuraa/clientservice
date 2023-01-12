package com.example.clientservice.configuration;

import com.example.clientservice.model.Client;
import com.example.clientservice.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository){
        return args -> {
            Client john = new Client(
                    "john",
                    "john@gmail.com",
                    22
            );

            Client alex = new Client(
                    "alex",
                    "alex@gmail.com",
                    25
            );
            repository.saveAll(
                List.of(john, alex)
            );
        };
    }
}
