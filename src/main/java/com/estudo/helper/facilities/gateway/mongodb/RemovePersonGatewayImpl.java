package com.estudo.helper.facilities.gateway.mongodb;

import com.estudo.helper.facilities.controller.exception.PersonNotFoundException;
import com.estudo.helper.facilities.gateway.mongodb.model.PersonDBDomain;
import com.estudo.helper.facilities.gateway.mongodb.repository.PersonRepository;
import com.estudo.helper.facilities.gateway.mongodb.repository.RemovePersonGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class RemovePersonGatewayImpl implements RemovePersonGateway {

    private  final FindPersonByEmailGatewayImpl findPersonByEmailGateway;
    private final PersonRepository personRepository;

    @Override
    public void removePerson(String email) throws PersonNotFoundException {
        try {
            Optional<PersonDBDomain> find = findPersonByEmailGateway.findUserByEmail(email);
            if(!find.isPresent()){
                throw new Exception("nao oasnf");
            }
            personRepository.deletePersonByEmail(email);
        } catch (Exception e) {
            throw new PersonNotFoundException("Nao foi possivel...", e);
        }
    }
}
