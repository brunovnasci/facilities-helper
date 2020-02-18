package com.estudo.helper.facilities.gateway.mongodb.repository;

import com.estudo.helper.facilities.gateway.mongodb.model.AlertDBDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlertRepository extends MongoRepository<AlertDBDomain, String> {
}
