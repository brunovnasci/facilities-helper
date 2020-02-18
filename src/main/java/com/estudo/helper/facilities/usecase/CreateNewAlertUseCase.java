package com.estudo.helper.facilities.usecase;

import com.estudo.helper.facilities.controller.mapper.Translator;
import com.estudo.helper.facilities.controller.model.AlertResponse;
import com.estudo.helper.facilities.entities.Alert;
import com.estudo.helper.facilities.gateway.mongodb.repository.CreateNewAlertGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateNewAlertUseCase {

    private final CreateNewAlertGateway createNewAlertGateway;

    public AlertResponse execute(Alert alert) {
        return Translator.translate(createNewAlertGateway.create(alert), AlertResponse.class);
    }
}
