package com.codetron.wallet.exceptions;

/**
 * Created by josetesan on 1/05/16.
 */
public class WalletAlreadyExistsException extends RuntimeException {

    public WalletAlreadyExistsException(final Long userId) {
        super("Wallet already exists for user "+userId);
    }
}
