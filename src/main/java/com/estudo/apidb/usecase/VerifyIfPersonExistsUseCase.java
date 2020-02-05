package com.estudo.apidb.usecase;

import com.estudo.apidb.controller.exception.GenericServerException;
import com.estudo.apidb.controller.exception.UserAlreadyExistAuthenticationException;
import com.estudo.apidb.gateway.mongodb.model.PersonDBDomain;
import com.estudo.apidb.gateway.mongodb.repository.FindPersonByEmailGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VerifyIfPersonExistsUseCase {

    private final FindPersonByEmailGateway findPersonByEmailGateway;

    public void execute(String email) throws UserAlreadyExistAuthenticationException, GenericServerException {
        Optional<PersonDBDomain> userByEmail = findPersonByEmailGateway.findUserByEmail(email);
        if (userByEmail.isPresent()) {
            throw new UserAlreadyExistAuthenticationException("That user is already registered!");
        }
    }
}