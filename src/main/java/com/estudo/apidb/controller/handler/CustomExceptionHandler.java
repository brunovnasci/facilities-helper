package com.estudo.apidb.controller.handler;

import com.estudo.apidb.controller.exception.EmailFormatIsNotValidException;
import com.estudo.apidb.controller.exception.GenericServerException;
import com.estudo.apidb.controller.exception.UserAlreadyExistAuthenticationException;
import com.estudo.apidb.controller.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({UserAlreadyExistAuthenticationException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleAlreadyExistUser(final UserAlreadyExistAuthenticationException e) {
        return new ErrorResponse("Usuario ja cadastrado!");
    }

    @ExceptionHandler({EmailFormatIsNotValidException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleEmailFormatIsNotValid(final EmailFormatIsNotValidException e) {
        return new ErrorResponse("Formato do email invalido!");
    }

    @ExceptionHandler({GenericServerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handlerCanNotRemovePerson(final GenericServerException e) {
        return new ErrorResponse("Problema no servidor!");
    }
}
