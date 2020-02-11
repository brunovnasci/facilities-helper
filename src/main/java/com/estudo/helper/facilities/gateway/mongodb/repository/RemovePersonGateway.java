package com.estudo.helper.facilities.gateway.mongodb.repository;

import com.estudo.helper.facilities.controller.exception.PersonNotFoundException;

public interface RemovePersonGateway  {
    void removePerson(String email) throws PersonNotFoundException;
}
