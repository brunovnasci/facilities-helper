package com.estudo.helper.facilities.controller;

import com.estudo.helper.facilities.controller.exception.GenericServerException;
import com.estudo.helper.facilities.controller.exception.NotAuthorizedException;
import com.estudo.helper.facilities.controller.exception.PersonIsNotCleanerException;
import com.estudo.helper.facilities.controller.exception.PersonNotFoundException;
import com.estudo.helper.facilities.controller.mapper.Translator;
import com.estudo.helper.facilities.controller.model.AlertRequest;
import com.estudo.helper.facilities.controller.model.AlertResponse;
import com.estudo.helper.facilities.entities.Alert;
import com.estudo.helper.facilities.usecase.CreateNewAlertUseCase;
import com.estudo.helper.facilities.usecase.GetAllAlertsUseCase;
import com.estudo.helper.facilities.usecase.UpdateAlertStatusUseCase;
import com.estudo.helper.facilities.usecase.ValidateTokenUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/alert")
@RequiredArgsConstructor
public class AlertController {

    private final GetAllAlertsUseCase getAllAlertsUseCase;
    private final CreateNewAlertUseCase createNewAlertUseCase;
    private final ValidateTokenUseCase validateTokenUseCase;
    private final UpdateAlertStatusUseCase updateAlertStatusUseCase;

    @GetMapping
    public ResponseEntity<List<AlertResponse>> getAlerts(){
        return new ResponseEntity<>(getAllAlertsUseCase.execute(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AlertResponse> postAlert(@RequestBody AlertRequest request, @RequestHeader("Authorization") String jwt) throws NotAuthorizedException, PersonNotFoundException, GenericServerException {
        request.setPerson(validateTokenUseCase.validate(jwt));
        return new ResponseEntity<>(createNewAlertUseCase.execute(Translator.translate(request, Alert.class)), HttpStatus.OK);
    }

    @PutMapping("{id}/{status}")
    public ResponseEntity<AlertResponse> putAlert(@PathVariable(value = "id") String alertId, @PathVariable(value = "status") boolean alertStatus, @RequestHeader("Authorization") String jwt) throws NotAuthorizedException, PersonNotFoundException, GenericServerException, PersonIsNotCleanerException {
        String jwtId = validateTokenUseCase.validate(jwt);
        return new ResponseEntity<>(updateAlertStatusUseCase.execute(alertId, jwtId, alertStatus) ,HttpStatus.OK);
    }
}
