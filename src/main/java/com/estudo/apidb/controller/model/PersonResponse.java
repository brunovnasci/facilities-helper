package com.estudo.apidb.controller.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {
    private String id;
    private String nome;
    private String sobrenome;
    private String email;

}
