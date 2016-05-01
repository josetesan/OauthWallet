package com.codetron.wallet.controller;

import com.codetron.wallet.entities.Wallet;
import com.codetron.wallet.jpa.WalletRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by josetesan on 1/05/16.
 */
@Service
public class WalletService {


    private WalletRepository walletRepository;

    @Inject
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }


    public Optional<Wallet> findWalletByUserId(final Long userId) {
        return Optional.ofNullable(this.walletRepository.findByUserId(userId));
    }

    public Wallet saveWallet(final Wallet wallet) {
        return this.walletRepository.save(wallet);
    }
}
