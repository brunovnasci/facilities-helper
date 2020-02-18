package com.estudo.helper.facilities.gateway.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Document(collection = "alert")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertDBDomain {
    @Id
    private String id;
    private int andar;
    private String generoBanheiro;
    private String mensagem;
    private String person;
    private Instant dataDeCriacao = LocalDateTime.now().toInstant(OffsetDateTime.now().getOffset());
    private boolean estaFeita = false;
    private Instant dataDeConclusao = null;

}
