package com.estudo.helper.facilities.controller.exception;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(String msg){
        super(msg);
    }

    public PersonNotFoundException(String msg, Exception e) {
        super(msg, e);
    }
}
