package com.estudo.helper.facilities.gateway.mongodb;

import com.estudo.helper.facilities.gateway.mongodb.model.AlertDBDomain;
import com.estudo.helper.facilities.gateway.mongodb.repository.AlertRepository;
import com.estudo.helper.facilities.gateway.mongodb.repository.GetAllAlertsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetAllAlertsGatewayImpl implements GetAllAlertsGateway {
    private final AlertRepository alertRepository;

    @Override
    public List<AlertDBDomain> get() {
        return alertRepository.findAll();
    }
}
