package com.codetron.wallet.configuration;

import com.codetron.wallet.exceptions.WalletAlreadyExistsException;
import com.codetron.wallet.exceptions.WalletNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by josetesan on 1/05/16.
 */
@ControllerAdvice
public class WalletControllerAdvice {

    @ExceptionHandler(WalletAlreadyExistsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String walletAlreadyExistsException(final Long userId) {
        return String.format("Wallet already exists for user %s",userId);
    }


    @ExceptionHandler(WalletNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String walletNotFoundException(final Long userId){
        return String.format("Wallet do not exists for user %s",userId);
    }

}
