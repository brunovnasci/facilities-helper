package com.estudo.helper.facilities.gateway.mongodb;

import com.estudo.helper.facilities.entities.Alert;
import com.estudo.helper.facilities.gateway.mongodb.model.AlertDBDomain;
import com.estudo.helper.facilities.gateway.mongodb.repository.AlertRepository;
import com.estudo.helper.facilities.gateway.mongodb.repository.UpdateAlertStatusGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateAlertStatusGatewayImpl implements UpdateAlertStatusGateway {

    private final AlertRepository alertRepository;

    @Override
    public AlertDBDomain update(Alert alert) {
        AlertDBDomain alertBD = alertRepository.findById(alert.getId()).get();
        alertBD.setEstaFeita(alert.isEstaFeita());
        alertBD.setDataDeConclusao(alert.getDataDeConclusao());

        return alertRepository.save(alertBD);
    }
}
