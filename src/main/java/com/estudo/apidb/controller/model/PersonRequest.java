package com.estudo.apidb.controller.model;

import lombok.Data;

@Data
public class PersonRequest {
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;

}
