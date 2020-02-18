package com.estudo.helper.facilities.gateway.mongodb.repository;

import com.estudo.helper.facilities.gateway.mongodb.model.PersonDBDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<PersonDBDomain, String> {
    PersonDBDomain findUserByEmail(String email);
    void deletePersonByEmail(String email);
}
