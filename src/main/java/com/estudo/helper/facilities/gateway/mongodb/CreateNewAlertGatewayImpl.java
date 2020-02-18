package com.estudo.helper.facilities.gateway.mongodb;

import com.estudo.helper.facilities.controller.mapper.Translator;
import com.estudo.helper.facilities.entities.Alert;
import com.estudo.helper.facilities.gateway.mongodb.model.AlertDBDomain;
import com.estudo.helper.facilities.gateway.mongodb.repository.AlertRepository;
import com.estudo.helper.facilities.gateway.mongodb.repository.CreateNewAlertGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateNewAlertGatewayImpl implements CreateNewAlertGateway {

    private final AlertRepository alertRepository;

    @Override
    public AlertDBDomain create(Alert alert) {
        return alertRepository.save(Translator.translate(alert, AlertDBDomain.class));
    }
}
