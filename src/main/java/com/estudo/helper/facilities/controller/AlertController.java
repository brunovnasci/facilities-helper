package com.estudo.helper.facilities.controller;

import com.estudo.helper.facilities.controller.exception.*;
import com.estudo.helper.facilities.controller.mapper.Translator;
import com.estudo.helper.facilities.controller.model.AlertRequest;
import com.estudo.helper.facilities.controller.model.AlertResponse;
import com.estudo.helper.facilities.entities.Alert;
import com.estudo.helper.facilities.usecase.*;
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
    private final GetAlertByIdUseCase getAlertByIdUseCase;
    private final GetAlertByPersonEmailUseCase getAlertByPersonEmailUseCase;

    @GetMapping
    public ResponseEntity<List<AlertResponse>> getAlerts(@RequestHeader("Authorization") String jwt) throws NotAuthorizedException, PersonNotFoundException, GenericServerException, ExpiredJwtException, TokenException, PersonIsNotCleanerException {
        String personId = validateTokenUseCase.validate(jwt);
        List<AlertResponse> listaOrdenada = getAllAlertsUseCase.execute(personId);
        listaOrdenada.sort(AlertResponse::compare);

        return new ResponseEntity<>(listaOrdenada, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertResponse> getAlertsById(@RequestHeader("Authorization") String jwt, @PathVariable("id") String alertId) throws NotAuthorizedException, PersonNotFoundException, GenericServerException, ExpiredJwtException, TokenException, AlertNotFoundException {
        validateTokenUseCase.validate(jwt);
        return new ResponseEntity<>(getAlertByIdUseCase.execute(alertId), HttpStatus.OK);
    }

    @GetMapping("/person")
    public ResponseEntity<List<AlertResponse>> getAlertsByPersonEmail(@RequestHeader("Authorization") String jwt) throws NotAuthorizedException, PersonNotFoundException, GenericServerException, ExpiredJwtException, TokenException {
        String personId = validateTokenUseCase.validate(jwt);
        return new ResponseEntity<>(getAlertByPersonEmailUseCase.execute(personId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AlertResponse> postAlert(@RequestBody AlertRequest request, @RequestHeader("Authorization") String jwt) throws NotAuthorizedException, PersonNotFoundException, GenericServerException, ExpiredJwtException, TokenException {
        return new ResponseEntity<>(createNewAlertUseCase.execute(Translator.translate(request, Alert.class), validateTokenUseCase.validate(jwt)), HttpStatus.OK);
    }

    @PutMapping("{id}/{status}")
    public ResponseEntity<AlertResponse> putAlert(@PathVariable(value = "id") String alertId, @PathVariable(value = "status") boolean alertStatus, @RequestHeader("Authorization") String jwt) throws NotAuthorizedException, PersonNotFoundException, GenericServerException, PersonIsNotCleanerException, ExpiredJwtException, TokenException {
        String jwtId = validateTokenUseCase.validate(jwt);
        return new ResponseEntity<>(updateAlertStatusUseCase.execute(alertId, jwtId, alertStatus) ,HttpStatus.OK);
    }
}
