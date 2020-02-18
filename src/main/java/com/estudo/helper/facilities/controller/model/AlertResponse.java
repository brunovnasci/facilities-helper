package com.estudo.helper.facilities.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlertResponse {
    private String id;
    private int andar;
    private String generoBanheiro;
    private String mensagem;
    private String person;
    private Instant dataDeCriacao;
    private boolean estaFeita;
    private Instant dataDeConclusao;

}
