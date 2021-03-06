package com.estudo.helper.facilities.controller;

import com.estudo.helper.facilities.controller.annotation.LoginRequired;
import com.estudo.helper.facilities.controller.exception.*;
import com.estudo.helper.facilities.controller.mapper.Translator;
import com.estudo.helper.facilities.controller.model.JwtResponse;
import com.estudo.helper.facilities.controller.model.PersonRequest;
import com.estudo.helper.facilities.controller.model.PersonResponse;
import com.estudo.helper.facilities.entities.Person;
import com.estudo.helper.facilities.entities.Role;
import com.estudo.helper.facilities.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final CreateNewPersonUseCase createNewPersonUseCase;
    private final RemovePersonUseCase removePersonUseCase;
    private final GeneratePersonJWTUseCase generatePersonJWTUseCase;
    private final GetPersonByIdUseCase getPersonById;
    private final ValidateTokenUseCase validateTokenUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> getPerson(@PathVariable(value = "id") String id, @RequestHeader("Authorization") String jwt) throws PersonNotFoundException {
        return new ResponseEntity<>(getPersonById.execute(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PersonResponse> getPersonByJwt(@RequestHeader("Authorization") String jwt) throws PersonNotFoundException, ExpiredJwtException, NotAuthorizedException, GenericServerException, TokenException {
        String id = validateTokenUseCase.validate(jwt);
        return new ResponseEntity<>(getPersonById.execute(id), HttpStatus.OK);
    }

    @PostMapping("/{role}")
    public ResponseEntity<PersonResponse> postPerson(@RequestBody PersonRequest request, @PathVariable(value = "role") Role role) throws GenericServerException {
        return new ResponseEntity<>(createNewPersonUseCase.execute(Translator.translate(request, Person.class), role), HttpStatus.OK);
    }


    @PostMapping("/jwt")
    public ResponseEntity<JwtResponse> getJwt(@RequestBody PersonRequest request) throws GenericServerException, CredentialsAreNotValidException {
        return new ResponseEntity<>(generatePersonJWTUseCase.execute(Translator.translate(request, Person.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{email}")
    @LoginRequired
    public ResponseEntity<String> deletePerson(@PathVariable(value = "email") String email, @RequestHeader(value = "Authorization") String jwt) throws Exception {
        removePersonUseCase.remove(email, jwt);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }
}
