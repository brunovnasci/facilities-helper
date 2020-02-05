package com.estudo.apidb.gateway.mongodb;

import com.estudo.apidb.controller.exception.GenericServerException;
import com.estudo.apidb.gateway.mongodb.repository.PersonRepository;
import com.estudo.apidb.gateway.mongodb.repository.RemovePersonGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RemovePersonGatewayImpl implements RemovePersonGateway {

    private final PersonRepository personRepository;

    @Override
    public void removePerson(String email) throws GenericServerException {
        try {
            personRepository.deletePersonByEmail(email);
        } catch (Exception e) {
            throw new GenericServerException("Nao foi possivel...", e);
        }
    }
}
