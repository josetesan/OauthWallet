package com.codetron.wallet.jpa;

import com.codetron.wallet.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by josetesan on 1/05/16.
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long>{

    Wallet findByUserId(final Long userId);

}
