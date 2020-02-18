package com.estudo.helper.facilities.usecase;

import com.estudo.helper.facilities.controller.exception.PersonIsNotCleanerException;
import com.estudo.helper.facilities.controller.mapper.Translator;
import com.estudo.helper.facilities.controller.model.AlertResponse;
import com.estudo.helper.facilities.entities.Alert;
import com.estudo.helper.facilities.gateway.mongodb.repository.UpdateAlertStatusGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
public class UpdateAlertStatusUseCase {

    private final VerifyIfPersonIsCleanerUseCase verifyIfPersonIsCleanerUseCase;
    private final UpdateAlertStatusGateway updateAlertStatusGateway;

    public AlertResponse execute(String alertId, String personId, boolean alertStatus) throws PersonIsNotCleanerException {
        verifyIfPersonIsCleanerUseCase.verify(personId);
        Alert alert = new Alert();
        alert.setId(alertId);
        alert.setDataDeConclusao(LocalDateTime.now().toInstant(OffsetDateTime.now().getOffset()));
        alert.setEstaFeita(alertStatus);

        return Translator.translate(updateAlertStatusGateway.update(alert), AlertResponse.class);
    }
}
