package com.estudo.helper.facilities.controller;

import com.estudo.helper.facilities.controller.model.AlertRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alert")
@RequiredArgsConstructor
public class AlertController {

    @GetMapping
    public ResponseEntity< /*AlertResponse*/ String> getAlerts(@RequestBody AlertRequest request){
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
