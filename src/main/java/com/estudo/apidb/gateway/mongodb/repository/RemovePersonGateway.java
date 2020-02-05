package com.estudo.apidb.gateway.mongodb.repository;

import com.estudo.apidb.controller.exception.GenericServerException;

public interface RemovePersonGateway  {
    void removePerson(String email) throws GenericServerException;
}
