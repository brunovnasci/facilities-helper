package com.estudo.helper.facilities.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private Role role;

}
