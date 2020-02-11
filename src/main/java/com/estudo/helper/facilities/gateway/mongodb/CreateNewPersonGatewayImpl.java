package com.estudo.helper.facilities.gateway.mongodb;

import com.estudo.helper.facilities.controller.exception.GenericServerException;
import com.estudo.helper.facilities.entities.Person;
import com.estudo.helper.facilities.gateway.mongodb.model.PersonDBDomain;
import com.estudo.helper.facilities.gateway.mongodb.repository.CreateNewPersonGateway;
import com.estudo.helper.facilities.gateway.mongodb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateNewPersonGatewayImpl implements CreateNewPersonGateway {

    private final PersonRepository personRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();


    @Override
    public PersonDBDomain create(Person person) throws GenericServerException {
        try{
            person.setSenha(encoder.encode(person.getSenha()));
            Person save = personRepository.save(person);
            return personRepository.findUserByEmail(save .getEmail());
        }catch (Exception e) {
            throw new GenericServerException("Nao foi possivel...", e);
        }
    }
}
