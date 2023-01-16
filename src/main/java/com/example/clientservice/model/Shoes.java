package com.example.clientservice.model;

import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "shoes")
@AllArgsConstructor
@NoArgsConstructor
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class Shoes {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @Column(name = "s_type")
    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
    private ShoesType shoesType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id", nullable=false)
    Client client;
}
