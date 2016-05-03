package com.codetron.wallet.controller;

import com.codetron.wallet.entities.Wallet;
import com.codetron.wallet.exceptions.WalletAlreadyExistsException;
import com.codetron.wallet.exceptions.WalletNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * Created by josetesan on 1/05/16.
 */
@RestController
@RequestMapping("/wallet")
public class WalletController {


    private WalletService walletService;

    @Inject
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @RequestMapping(value = "/{user}",method = RequestMethod.GET)
    @PreAuthorize("#oauth2.hasScope('wallet')")
    public ResponseEntity<?> getWallet(@PathVariable("user") final Long userId) throws Exception {

        final Wallet wallet = this.walletService.findWalletByUserId(userId)
                .orElseThrow(() -> new WalletNotFoundException(userId));
        return ResponseEntity.ok(wallet);
    }


    @RequestMapping(value="/{user}/{amount}",method = RequestMethod.POST)
    @PreAuthorize("#oauth2.hasScope('wallet')")
    public ResponseEntity<?> createWallet(@PathVariable("user") final Long userId,
                                          @PathVariable("amount") final BigDecimal amount) throws Exception{

        boolean exists =
                this.walletService
                .findWalletByUserId(userId)
                .isPresent();

        if (exists) throw new WalletAlreadyExistsException(userId);

        final Wallet wallet = new Wallet(userId,amount);
        this.walletService.saveWallet(wallet);
        return new ResponseEntity<>(wallet,HttpStatus.CREATED);

    }

}
