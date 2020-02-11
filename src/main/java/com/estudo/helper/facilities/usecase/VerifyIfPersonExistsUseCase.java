package com.estudo.helper.facilities.usecase;

import com.estudo.helper.facilities.controller.exception.GenericServerException;
import com.estudo.helper.facilities.controller.exception.UserAlreadyExistAuthenticationException;
import com.estudo.helper.facilities.gateway.mongodb.model.PersonDBDomain;
import com.estudo.helper.facilities.gateway.mongodb.repository.FindPersonByEmailGateway;
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