package com.estudo.helper.facilities.controller.exception;

public class ExpiredJwtException extends Exception {
    public ExpiredJwtException(String msg){
        super(msg);
    }
}
