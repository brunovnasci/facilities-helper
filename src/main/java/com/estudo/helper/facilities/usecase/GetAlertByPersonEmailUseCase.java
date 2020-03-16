package com.estudo.helper.facilities.usecase;

import com.estudo.helper.facilities.controller.mapper.Translator;
import com.estudo.helper.facilities.controller.model.AlertResponse;
import com.estudo.helper.facilities.entities.Person;
import com.estudo.helper.facilities.gateway.mongodb.model.AlertDBDomain;
import com.estudo.helper.facilities.gateway.mongodb.repository.AlertRepository;
import com.estudo.helper.facilities.gateway.mongodb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class GetAlertByPersonEmailUseCase {

    private final AlertRepository alertRepository;
    private final PersonRepository personRepository;

    public List<AlertResponse> execute(String personId){
        Person person = Translator.translate(personRepository.findById(personId).get(), Person.class);
        List<AlertDBDomain> alertDBDomains = alertRepository.findByPersonEmail(person.getEmail());
        return alertDBDomains.stream().map(alertDBDomain -> Translator.translate(alertDBDomain, AlertResponse.class)).collect(Collectors.toList());
    }
}
