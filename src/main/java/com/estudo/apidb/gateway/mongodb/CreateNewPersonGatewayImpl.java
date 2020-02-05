package com.estudo.apidb.gateway.mongodb;

import com.estudo.apidb.controller.exception.GenericServerException;
import com.estudo.apidb.entities.Person;
import com.estudo.apidb.gateway.mongodb.model.PersonDBDomain;
import com.estudo.apidb.gateway.mongodb.repository.CreateNewPersonGateway;
import com.estudo.apidb.gateway.mongodb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateNewPersonGatewayImpl implements CreateNewPersonGateway {

    private final PersonRepository personRepository;

    @Override
    public PersonDBDomain create(Person person) throws GenericServerException {
        try{
            Person save = personRepository.save(person);
            PersonDBDomain find = personRepository.findUserByEmail(save.getEmail());
            return find;
        }catch (Exception e) {
            throw new GenericServerException("Nao foi possivel...", e);
        }
    }
}
