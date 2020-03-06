package com.estudo.helper.facilities.usecase;

import com.estudo.helper.facilities.controller.exception.AlertNotFoundException;
import com.estudo.helper.facilities.controller.mapper.Translator;
import com.estudo.helper.facilities.controller.model.AlertResponse;
import com.estudo.helper.facilities.gateway.mongodb.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetAlertByIdUseCase {

    private final AlertRepository alertRepository;
    private final VerifyIfAlertExistsUseCase verifyIfAlertExistsUseCase;

    public AlertResponse execute(String alertId) throws AlertNotFoundException {
        verifyIfAlertExistsUseCase.execute(alertId);
        return Translator.translate(alertRepository.findById(alertId).get(), AlertResponse.class);
    }

}
