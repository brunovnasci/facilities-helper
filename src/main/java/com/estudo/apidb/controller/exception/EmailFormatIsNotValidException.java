package com.estudo.apidb.controller.exception;

public class EmailFormatIsNotValidException extends RuntimeException {

    public EmailFormatIsNotValidException(final String msg) {
        super(msg);
    }

}
