package com.estudo.apidb.controller;

import com.estudo.apidb.controller.exception.GenericServerException;
import com.estudo.apidb.controller.mapper.Translator;
import com.estudo.apidb.controller.model.PersonRequest;
import com.estudo.apidb.controller.model.PersonResponse;
import com.estudo.apidb.entities.Person;
import com.estudo.apidb.usecase.CreateNewPersonUseCase;
import com.estudo.apidb.usecase.RemovePersonUseCase;
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

    @PostMapping
    public ResponseEntity<PersonResponse> postPerson(@RequestBody PersonRequest request) throws GenericServerException {
        return new ResponseEntity<>(createNewPersonUseCase.execute(Translator.translate(request, Person.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{email}")
    public void deletePerson(@PathVariable(value = "email") String email) throws GenericServerException {
        removePersonUseCase.remove(email);
    }
}
