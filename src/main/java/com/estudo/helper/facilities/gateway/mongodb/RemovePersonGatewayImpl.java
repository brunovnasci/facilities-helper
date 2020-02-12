package com.estudo.helper.facilities.gateway.mongodb;

import com.estudo.helper.facilities.gateway.mongodb.repository.PersonRepository;
import com.estudo.helper.facilities.gateway.mongodb.repository.RemovePersonGateway;
import com.estudo.helper.facilities.usecase.ValidateTokenUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RemovePersonGatewayImpl implements RemovePersonGateway {

    private final PersonRepository personRepository;
    private final ValidateTokenUseCase validateTokenUseCase;

    @Override
    public void removePerson(String email) {
        personRepository.deletePersonByEmail(email);
    }
}
