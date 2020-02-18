package com.estudo.helper.facilities.gateway.mongodb.repository;

import com.estudo.helper.facilities.gateway.mongodb.model.PersonDBDomain;

import java.util.Optional;

public interface GetPersonByIdGateway {
    Optional<PersonDBDomain> get(String id);
}
