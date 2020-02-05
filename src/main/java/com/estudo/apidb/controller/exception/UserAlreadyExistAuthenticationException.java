package com.estudo.apidb.controller.exception;

import javax.naming.AuthenticationException;

public class UserAlreadyExistAuthenticationException extends RuntimeException {

    public UserAlreadyExistAuthenticationException(final String msg) {
        super(msg);
    }

}
