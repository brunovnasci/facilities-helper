package com.estudo.helper.facilities.gateway.mongodb;

import com.estudo.helper.facilities.controller.exception.GenericServerException;
import com.estudo.helper.facilities.gateway.mongodb.model.PersonDBDomain;
import com.estudo.helper.facilities.gateway.mongodb.repository.FindPersonByEmailGateway;
import com.estudo.helper.facilities.gateway.mongodb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindPersonByEmailGatewayImpl implements FindPersonByEmailGateway {

    private final PersonRepository personRepository;

    @Override
    public Optional<PersonDBDomain> findUserByEmail(String email) throws GenericServerException {
        try {
            return Optional.ofNullable(personRepository.findUserByEmail(email));
        }catch (Exception e){
            throw new GenericServerException("Nao foi possivel...", e);
        }
    }
}
