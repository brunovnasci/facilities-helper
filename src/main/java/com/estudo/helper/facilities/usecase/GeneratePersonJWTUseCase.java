package com.estudo.helper.facilities.usecase;

import com.estudo.helper.facilities.controller.exception.GenericServerException;
import com.estudo.helper.facilities.controller.exception.PersonNotFoundException;
import com.estudo.helper.facilities.controller.exception.ThePasswordIsWrongException;
import com.estudo.helper.facilities.controller.model.JwtResponse;
import com.estudo.helper.facilities.entities.Jwt;
import com.estudo.helper.facilities.entities.Person;
import com.estudo.helper.facilities.gateway.mongodb.model.PersonDBDomain;
import com.estudo.helper.facilities.gateway.mongodb.repository.FindPersonByEmailGateway;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static io.jsonwebtoken.Jwts.claims;
import static org.springframework.security.crypto.factory.PasswordEncoderFactories.createDelegatingPasswordEncoder;

@Component
@RequiredArgsConstructor
public class GeneratePersonJWTUseCase {

    private final VerifyIfEmailIsValidUseCase verifyIfEmailIsValidUseCase;
    private final FindPersonByEmailGateway findPersonByEmailGateway;
    private final Jwt jwt;

    public JwtResponse execute(Person person) throws ThePasswordIsWrongException, PersonNotFoundException, GenericServerException {
        verifyIfEmailIsValidUseCase.execute(person.getEmail());
        PersonDBDomain userByEmail = findPersonByEmailGateway.findUserByEmail(person.getEmail()).orElseThrow(() -> new PersonNotFoundException("Pessoa nao foi achada!"));

        if (!createDelegatingPasswordEncoder().matches(person.getSenha(), userByEmail.getSenha())) {
            throw new ThePasswordIsWrongException("A senha nao esta correta");
        }

        Claims claims = claims();
        claims.put("id", userByEmail.getId());
        claims.put("email", userByEmail.getEmail());

        Jwt.JwtTokens jwtTokens = jwt.codificar(claims);
        return new JwtResponse(jwtTokens.getJwt(), jwtTokens.getJwtRefresh());
    }
}
