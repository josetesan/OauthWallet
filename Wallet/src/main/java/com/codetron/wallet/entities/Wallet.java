package com.codetron.wallet.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by josetesan on 1/05/16.
 */
@Table(name="WALLET",indexes = @Index(unique = true,columnList = "USERID"))
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "USERID",nullable = false)
    private Long userId;
    @Column(name = "AMOUNT",nullable = false)
    private BigDecimal amount;

    public Wallet() { // JPA
    }

    public Wallet(final Long userId, final BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wallet wallet = (Wallet) o;

        if (id != null ? !id.equals(wallet.id) : wallet.id != null) return false;
        if (userId != null ? !userId.equals(wallet.userId) : wallet.userId != null) return false;
        return amount != null ? amount.equals(wallet.amount) : wallet.amount == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Wallet{");
        sb.append("amount=").append(amount);
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append('}');
        return sb.toString();
    }


}
