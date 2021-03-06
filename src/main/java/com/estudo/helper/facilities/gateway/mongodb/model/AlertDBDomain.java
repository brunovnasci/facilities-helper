package com.estudo.helper.facilities.gateway.mongodb.model;

import com.estudo.helper.facilities.controller.model.PersonResponse;
import com.estudo.helper.facilities.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Document(collection = "alert")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertDBDomain {
    public static final String AMERICA_SAO_PAULO = "America/Sao_Paulo";
    @Id
    private String id;
    private String andar;
    private String comodo;
    private String mensagem;
    private PersonResponse person;
    private ZoneId zonedId = ZoneId.of(AMERICA_SAO_PAULO);
    private Instant dataDeCriacao = LocalDateTime.now().toInstant(OffsetDateTime.now().toLocalDateTime().atZone(zonedId).getOffset());
    private boolean estaFeita = false;
    private Instant dataDeConclusao = null;

}
