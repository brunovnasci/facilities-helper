package com.estudo.helper.facilities.usecase;

import com.estudo.helper.facilities.controller.exception.GenericServerException;
import com.estudo.helper.facilities.controller.mapper.Translator;
import com.estudo.helper.facilities.controller.model.PersonResponse;
import com.estudo.helper.facilities.entities.Person;
import com.estudo.helper.facilities.gateway.mongodb.repository.CreateNewPersonGateway;
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
            return Translator.translate(createNewPersonGateway.create(person), PersonResponse.class);
        } catch (GenericServerException e) {
            throw new GenericServerException(e.getMessage(), e);
        }
    }
}
