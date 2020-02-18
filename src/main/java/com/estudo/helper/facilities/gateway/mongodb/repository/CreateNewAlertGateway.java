package com.estudo.helper.facilities.gateway.mongodb.repository;

import com.estudo.helper.facilities.entities.Alert;
import com.estudo.helper.facilities.gateway.mongodb.model.AlertDBDomain;

public interface CreateNewAlertGateway {
    AlertDBDomain create(Alert alert);
}
