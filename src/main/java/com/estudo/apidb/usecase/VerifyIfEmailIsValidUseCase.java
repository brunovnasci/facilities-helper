package com.estudo.apidb.usecase;

import com.estudo.apidb.controller.exception.EmailFormatIsNotValidException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VerifyIfEmailIsValidUseCase {

    public void execute(String email){
        if(!EmailValidator.getInstance().isValid(email)){
            throw new EmailFormatIsNotValidException("The email format is not valid");
        }
    }
}
