package com.estudo.apidb.controller.exception;

public class GenericServerException extends Exception {

    public GenericServerException(String msg){
        super(msg);
    }

    public GenericServerException(String msg, Throwable e){
        super(msg, e);
    }
}
