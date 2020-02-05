package com.estudo.apidb.usecase;

import com.estudo.apidb.controller.exception.GenericServerException;
import com.estudo.apidb.gateway.mongodb.repository.RemovePersonGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemovePersonUseCase {
    private final RemovePersonGateway removePersonGateway;

    public void remove(String email) throws GenericServerException {
        removePersonGateway.removePerson(email);
    }
}
