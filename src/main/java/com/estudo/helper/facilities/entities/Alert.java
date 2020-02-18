package com.estudo.helper.facilities.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alert {
    private String id;
    private int andar;
    private String generoBanheiro;
    private String mensagem;
    private boolean estaFeita;
    private Instant dataDeConclusao;
    private String person;

}
