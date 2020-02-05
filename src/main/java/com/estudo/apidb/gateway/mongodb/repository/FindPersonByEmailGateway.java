package com.estudo.apidb.gateway.mongodb.repository;

import com.estudo.apidb.controller.exception.GenericServerException;
import com.estudo.apidb.gateway.mongodb.model.PersonDBDomain;

import java.util.Optional;

public interface FindPersonByEmailGateway {
    Optional<PersonDBDomain> findUserByEmail(String email) throws GenericServerException;
}
