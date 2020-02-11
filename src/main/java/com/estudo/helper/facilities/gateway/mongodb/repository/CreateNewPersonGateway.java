package com.estudo.helper.facilities.gateway.mongodb.repository;

import com.estudo.helper.facilities.controller.exception.GenericServerException;
import com.estudo.helper.facilities.entities.Person;
import com.estudo.helper.facilities.gateway.mongodb.model.PersonDBDomain;

public interface CreateNewPersonGateway {
    PersonDBDomain create(Person person) throws GenericServerException;
}
