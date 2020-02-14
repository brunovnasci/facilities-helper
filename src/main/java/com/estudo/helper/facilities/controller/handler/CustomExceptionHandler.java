package com.estudo.helper.facilities.controller.handler;

import com.estudo.helper.facilities.controller.exception.*;
import com.estudo.helper.facilities.controller.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ErrorResponse handlerServerError(final GenericServerException e) {
        return new ErrorResponse("Problema no servidor!");
    }

    @ExceptionHandler({PersonNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerCanNotRemovePerson(final PersonNotFoundException e) {
        return new ErrorResponse("Pessoa nao foi achada!");
    }

    @ExceptionHandler({ThePasswordIsWrongException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handlerPasswordIsWrong(final ThePasswordIsWrongException e) {
        return new ErrorResponse("A senha esta errada!");
    }

    @ExceptionHandler(NotAuthorizedException.class)
    public ResponseEntity<ErrorResponse> handlerNotAuthorized(final  NotAuthorizedException e) {
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("HttpHeaders.WWW_AUTHENTICATE", "Token");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .headers(responseHeader)
                .body(new ErrorResponse("Nao permitido!"));
    }

    @ExceptionHandler(MissingHeaderFieldException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handlerMissingHeaderField(final MissingHeaderFieldException e){
        return new ErrorResponse("Falta campos no header!");
    }

    @ExceptionHandler(BearerAutenticationException.class)
    public ResponseEntity<ErrorResponse> handlerBearerAutentication(final BearerAutenticationException e){
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("HttpHeaders.WWW_AUTHENTICATE","Bearer");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .headers(responseHeader)
                .body(new ErrorResponse("Faltando prefixo Bearer"));
    }
}
