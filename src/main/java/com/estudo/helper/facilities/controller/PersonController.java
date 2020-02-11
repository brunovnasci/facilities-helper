package com.estudo.helper.facilities.controller;

import com.estudo.helper.facilities.controller.exception.GenericServerException;
import com.estudo.helper.facilities.controller.exception.PersonNotFoundException;
import com.estudo.helper.facilities.controller.exception.ThePasswordIsWrongException;
import com.estudo.helper.facilities.controller.mapper.Translator;
import com.estudo.helper.facilities.controller.model.JwtResponse;
import com.estudo.helper.facilities.controller.model.PersonRequest;
import com.estudo.helper.facilities.controller.model.PersonResponse;
import com.estudo.helper.facilities.entities.Person;
import com.estudo.helper.facilities.usecase.CreateNewPersonUseCase;
import com.estudo.helper.facilities.usecase.GeneratePersonJWTUseCase;
import com.estudo.helper.facilities.usecase.RemovePersonUseCase;
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

    @PostMapping
    public ResponseEntity<PersonResponse> postPerson(@RequestBody PersonRequest request) throws GenericServerException {
        return new ResponseEntity<>(createNewPersonUseCase.execute(Translator.translate(request, Person.class)), HttpStatus.OK);
    }


    @PostMapping("/jwt")
    public ResponseEntity<JwtResponse> getJwt(@RequestBody PersonRequest request) throws ThePasswordIsWrongException, PersonNotFoundException, GenericServerException {
        return new ResponseEntity<>(generatePersonJWTUseCase.execute(Translator.translate(request, Person.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> deletePerson(@PathVariable(value = "email") String email, @RequestHeader(value = "authorization") String header) throws PersonNotFoundException {
        removePersonUseCase.remove(email);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }
}
