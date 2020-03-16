package com.estudo.helper.facilities.controller.model;

import com.estudo.helper.facilities.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class AlertResponse {
    private String id;
    private String andar;
    private String comodo;
    private String mensagem;
    private PersonResponse person;
    private Instant dataDeCriacao;
    private boolean estaFeita;
    private Instant dataDeConclusao;
    
    public int compare(AlertResponse t1) {
        return this.isEstaFeita() == t1.isEstaFeita() ? 0 : (this.isEstaFeita() ? 1 : -1);
    }


}
