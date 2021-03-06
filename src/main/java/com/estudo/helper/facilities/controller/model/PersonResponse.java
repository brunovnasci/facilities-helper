package com.estudo.helper.facilities.controller.model;

import com.estudo.helper.facilities.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {
    //private String id;
    private String nome;
    private String sobrenome;
    private String email;
    private Role role;
}
