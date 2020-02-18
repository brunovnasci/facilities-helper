package com.estudo.helper.facilities.gateway.mongodb.repository;

import com.estudo.helper.facilities.entities.Alert;
import com.estudo.helper.facilities.gateway.mongodb.model.AlertDBDomain;

public interface UpdateAlertStatusGateway {

    AlertDBDomain update(Alert alert);
}
