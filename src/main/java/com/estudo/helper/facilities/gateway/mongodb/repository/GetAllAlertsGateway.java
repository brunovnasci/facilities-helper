package com.estudo.helper.facilities.gateway.mongodb.repository;

import com.estudo.helper.facilities.gateway.mongodb.model.AlertDBDomain;

import java.util.List;

public interface GetAllAlertsGateway {
    List<AlertDBDomain> get();
}
