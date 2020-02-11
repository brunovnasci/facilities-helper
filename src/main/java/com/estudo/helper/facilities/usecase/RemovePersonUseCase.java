package com.estudo.helper.facilities.usecase;

import com.estudo.helper.facilities.controller.exception.PersonNotFoundException;
import com.estudo.helper.facilities.gateway.mongodb.repository.RemovePersonGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemovePersonUseCase {
    private final RemovePersonGateway removePersonGateway;
    private final ValidateTokenUseCase validateTokenUseCase;

    public void remove(String email) throws PersonNotFoundException {
        removePersonGateway.removePerson(email);
    }
}