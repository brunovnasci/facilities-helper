package com.estudo.apidb.gateway.mongodb.repository;

import com.estudo.apidb.controller.exception.GenericServerException;
import com.estudo.apidb.entities.Person;
import com.estudo.apidb.gateway.mongodb.model.PersonDBDomain;

public interface CreateNewPersonGateway {
    PersonDBDomain create(Person person) throws GenericServerException;
}
