package com.estudo.helper.facilities.usecase;

import com.estudo.helper.facilities.controller.exception.PersonIsNotCleanerException;
import com.estudo.helper.facilities.entities.Role;
import com.estudo.helper.facilities.gateway.mongodb.model.PersonDBDomain;
import com.estudo.helper.facilities.gateway.mongodb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VerifyIfPersonIsCleanerUseCase {

    private final PersonRepository personRepository;

    public void verify(String id) throws PersonIsNotCleanerException {
        Optional<PersonDBDomain> person = personRepository.findById(id);

        if(!person.get().getRole().equals(Role.CLEANER)){
            throw new PersonIsNotCleanerException("Essa pessoa nao e um faxineiro!");
        }
    }
}
