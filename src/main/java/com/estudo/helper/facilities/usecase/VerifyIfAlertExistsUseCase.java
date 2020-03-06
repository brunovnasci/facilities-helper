package com.estudo.helper.facilities.usecase;

import com.estudo.helper.facilities.controller.exception.AlertNotFoundException;
import com.estudo.helper.facilities.gateway.mongodb.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class VerifyIfAlertExistsUseCase {
    private final AlertRepository alertRepository;

    public void execute(String id) throws AlertNotFoundException {
        if(!alertRepository.findById(id).isPresent()){
            throw new AlertNotFoundException("Alerta nao foi achado!");
        }
    }
}
