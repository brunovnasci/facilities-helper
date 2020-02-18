package com.estudo.helper.facilities.usecase;

import com.estudo.helper.facilities.controller.exception.GenericServerException;
import com.estudo.helper.facilities.controller.exception.NotAuthorizedException;
import com.estudo.helper.facilities.controller.exception.PersonNotFoundException;
import com.estudo.helper.facilities.entities.Jwt;
import com.estudo.helper.facilities.gateway.mongodb.FindPersonByEmailGatewayImpl;
import com.estudo.helper.facilities.gateway.mongodb.model.PersonDBDomain;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ValidateTokenUseCase {

    private final FindPersonByEmailGatewayImpl findPersonByEmailGateway;
    private final VerifyIfEmailIsValidUseCase verifyIfEmailIsValidUseCase;
    private final Jwt jwt;

    public void validate(String email, String jwt) throws Exception {
        verifyIfEmailIsValidUseCase.execute(email);
        Optional<PersonDBDomain> find = findPersonByEmailGateway.findUserByEmail(email);
        if (!find.isPresent()) {
            throw new PersonNotFoundException("Nao foi possivel localizar o usuario!");
        }

        Claims claims = this.jwt.descodificar(jwt);
        String jwtEmail = claims.get("email", String.class);
        String jwtId = claims.get("id", String.class);
        String dbId = find.get().getId();
        String dbEmail = find.get().getEmail();

        if(!(dbId.equals(jwtId)) && (dbEmail.equals(jwtEmail))){
            throw new NotAuthorizedException("Not authorized!");
        }
    }

    public String validate(String jwt) throws GenericServerException, PersonNotFoundException, NotAuthorizedException {
        //decode do jwt para armazenar o payload
        Claims claims = this.jwt.descodificar(jwt);
        String jwtEmail = claims.get("email", String.class);
        String jwtId = claims.get("id", String.class);

        //verifica se a pessoa enviada do payload existe
        Optional<PersonDBDomain> find = findPersonByEmailGateway.findUserByEmail(jwtEmail);
        if (!find.isPresent()) {
            throw new PersonNotFoundException("Nao foi possivel localizar o usuario!");
        }

        //verifica se as credenciais estao certas
        String dbId = find.get().getId();
        String dbEmail = find.get().getEmail();
        if(!(dbId.equals(jwtId)) && (dbEmail.equals(jwtEmail))){
            throw new NotAuthorizedException("Not authorized!");
        }

        //retorna id da pessoa
        return dbId;
    }
}
