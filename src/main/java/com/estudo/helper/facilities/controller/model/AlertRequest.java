package com.estudo.helper.facilities.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlertRequest {
    private String andar;
    private String generoBanheiro;
    private String mensagem;
    private String person;

}
