package com.codetron.wallet.exceptions;

/**
 * Created by josetesan on 1/05/16.
 */
public class WalletNotFoundException extends RuntimeException {

    public WalletNotFoundException(final Long userId) {
            super("Wallet not found for user "+userId);
    }
}
