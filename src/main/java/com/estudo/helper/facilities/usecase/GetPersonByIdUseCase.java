package com.estudo.helper.facilities.usecase;

import com.estudo.helper.facilities.controller.exception.PersonNotFoundException;
import com.estudo.helper.facilities.controller.mapper.Translator;
import com.estudo.helper.facilities.controller.model.PersonResponse;
import com.estudo.helper.facilities.gateway.mongodb.model.PersonDBDomain;
import com.estudo.helper.facilities.gateway.mongodb.repository.GetPersonByIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetPersonByIdUseCase {

    private final GetPersonByIdGateway getPersonByIdGateway;

    public PersonResponse execute(String id) throws PersonNotFoundException {
        Optional<PersonDBDomain> person = getPersonByIdGateway.execute(id);
        if(!person.isPresent()){
            throw new PersonNotFoundException("Pessoa nao foi achada");
        }

        return Translator.translate(person.get(), PersonResponse.class);
    }
}
