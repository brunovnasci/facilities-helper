package com.estudo.helper.facilities.gateway.mongodb;

import com.estudo.helper.facilities.gateway.mongodb.model.PersonDBDomain;
import com.estudo.helper.facilities.gateway.mongodb.repository.GetPersonByIdGateway;
import com.estudo.helper.facilities.gateway.mongodb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetPersonByIdGatewayImpl implements GetPersonByIdGateway {

    private final PersonRepository personRepository;

    @Override
    public Optional<PersonDBDomain> get(String id) {
        return personRepository.findById(id);
    }
}
