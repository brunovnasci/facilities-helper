package com.estudo.helper.facilities.gateway.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDBDomain {
    @Id
    private String id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private Instant dataDeCriacao = new Date().toInstant();

}
