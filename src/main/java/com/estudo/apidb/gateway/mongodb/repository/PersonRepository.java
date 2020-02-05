package com.estudo.apidb.gateway.mongodb.repository;

import com.estudo.apidb.entities.Person;
import com.estudo.apidb.gateway.mongodb.model.PersonDBDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
    PersonDBDomain findUserByEmail(String email);
    void deletePersonByEmail(String email);
}
