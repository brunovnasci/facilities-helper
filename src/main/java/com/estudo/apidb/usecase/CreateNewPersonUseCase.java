package com.estudo.apidb.usecase;

import com.estudo.apidb.controller.exception.GenericServerException;
import com.estudo.apidb.controller.mapper.Translator;
import com.estudo.apidb.controller.model.PersonResponse;
import com.estudo.apidb.entities.Person;
import com.estudo.apidb.gateway.mongodb.repository.CreateNewPersonGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateNewPersonUseCase {

    private final CreateNewPersonGateway createNewPersonGateway;
    private final VerifyIfPersonExistsUseCase verifyIfPersonExistsUseCase;
    private final VerifyIfEmailIsValidUseCase verifyIfEmailIsValidUseCase;

    public PersonResponse execute(Person person) throws GenericServerException {
        verifyIfEmailIsValidUseCase.execute(person.getEmail());
        verifyIfPersonExistsUseCase.execute(person.getEmail());
        try {
            PersonResponse response = Translator.translate(createNewPersonGateway.create(person), PersonResponse.class);
            return response;
        } catch (GenericServerException e) {
            throw new GenericServerException(e.getMessage(), e);
        }
    }
}
