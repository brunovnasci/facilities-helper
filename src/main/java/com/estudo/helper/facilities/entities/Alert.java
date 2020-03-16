package com.estudo.helper.facilities.entities;

import com.estudo.helper.facilities.controller.model.PersonResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alert {
    private String id;
    private String andar;
    private String comodo;
    private String mensagem;
    private boolean estaFeita;
    private Instant dataDeConclusao;
    private PersonResponse person;

}
