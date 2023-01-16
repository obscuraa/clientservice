package com.example.clientservice.model;

import java.util.List;
import java.util.UUID;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "full_name")
    private String fullName;
    private String email;
    private Integer age;
    private String country;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Shoes> shoes;
}