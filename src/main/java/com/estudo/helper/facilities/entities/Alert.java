package com.estudo.helper.facilities.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alert {
    private int andar;
    private String generoBanheiro;
    private String mensagem;
    private String person;

}
