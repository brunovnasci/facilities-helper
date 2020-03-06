package com.estudo.helper.facilities.usecase;

import com.estudo.helper.facilities.controller.exception.PersonIsNotCleanerException;
import com.estudo.helper.facilities.controller.mapper.Translator;
import com.estudo.helper.facilities.controller.model.AlertResponse;
import com.estudo.helper.facilities.gateway.mongodb.model.AlertDBDomain;
import com.estudo.helper.facilities.gateway.mongodb.repository.GetAllAlertsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetAllAlertsUseCase {

    private final GetAllAlertsGateway getAllAlertsGateway;
    private final VerifyIfPersonIsCleanerUseCase verifyIfPersonIsCleanerUseCase;

    public List<AlertResponse> execute(String personId) throws PersonIsNotCleanerException {
        verifyIfPersonIsCleanerUseCase.verify(personId);
        List<AlertDBDomain> alertDBDomains = getAllAlertsGateway.get();
        return alertDBDomains.stream().map(alertDBDomain -> Translator.translate(alertDBDomain, AlertResponse.class)).collect(Collectors.toList());
    }
}
