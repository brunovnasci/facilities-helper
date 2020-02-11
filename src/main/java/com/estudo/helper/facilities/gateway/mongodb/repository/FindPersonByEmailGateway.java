package com.estudo.helper.facilities.gateway.mongodb.repository;

import com.estudo.helper.facilities.controller.exception.GenericServerException;
import com.estudo.helper.facilities.gateway.mongodb.model.PersonDBDomain;

import java.util.Optional;

public interface FindPersonByEmailGateway {
    Optional<PersonDBDomain> findUserByEmail(String email) throws GenericServerException;
}
