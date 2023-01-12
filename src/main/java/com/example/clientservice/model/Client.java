package com.example.clientservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Client {
    @Id
    @SequenceGenerator(name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private long id;
    private String name;
    private String email;
    private Integer age;

    public Client(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}