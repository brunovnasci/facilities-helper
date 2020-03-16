package com.estudo.helper.facilities.gateway.mongodb.repository;

import com.estudo.helper.facilities.gateway.mongodb.model.AlertDBDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlertRepository extends MongoRepository<AlertDBDomain, String> {
    List<AlertDBDomain> findByPersonEmail(String personEmail);
}
