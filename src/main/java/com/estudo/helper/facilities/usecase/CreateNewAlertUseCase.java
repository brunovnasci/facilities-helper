package com.estudo.helper.facilities.usecase;

import com.estudo.helper.facilities.controller.mapper.Translator;
import com.estudo.helper.facilities.controller.model.AlertResponse;
import com.estudo.helper.facilities.controller.model.PersonResponse;
import com.estudo.helper.facilities.entities.Alert;
import com.estudo.helper.facilities.entities.Person;
import com.estudo.helper.facilities.gateway.mongodb.repository.CreateNewAlertGateway;
import com.estudo.helper.facilities.gateway.mongodb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateNewAlertUseCase {

    private final CreateNewAlertGateway createNewAlertGateway;
    private final PersonRepository personRepository;

    public AlertResponse execute(Alert alert, String personId) {
        PersonResponse person = Translator.translate(personRepository.findById(personId).get(), PersonResponse.class);
        alert.setPerson(person);
        return Translator.translate(createNewAlertGateway.create(alert), AlertResponse.class);
    }
}
