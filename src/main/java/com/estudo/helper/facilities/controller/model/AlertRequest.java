package com.estudo.helper.facilities.controller.model;

import com.estudo.helper.facilities.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlertRequest {
    private String andar;
    private String comodo;
    private String mensagem;
    private PersonResponse person;

}
