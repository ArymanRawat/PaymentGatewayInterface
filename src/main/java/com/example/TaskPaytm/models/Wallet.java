package com.example.TaskPaytm.models;

import jakarta.persistence.*;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "mobileWallet")
    private Long mobileWallet;

    @Column(name = "balance")
    private long balance;

    @Column(name = "isCustomer")
    private boolean isCustomer;

    @Column(name = "haswallet")
    private boolean haswallet;


    public Wallet() {}

    public Wallet( Long mobileWallet) {

        super();
        this.mobileWallet = mobileWallet;
        this.isCustomer = true;
        this.balance = 0;
        this.haswallet = true;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getMobileWallet() {
        return mobileWallet;
    }

    public void setMobileWallet(Long mobileWallet) {
        this.mobileWallet = mobileWallet;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public boolean isCustomer() {
        return isCustomer;
    }

    public void setCustomer(boolean customer) {
        isCustomer = customer;
    }

    public boolean isHaswallet() {
        return haswallet;
    }

    public void setHaswallet(boolean haswallet) {
        this.haswallet = haswallet;
    }

//    public Wallet addNewWallet(long mobileWallet){
//        Wallet newWallet = new Wallet(mobileWallet);
//        return newWallet;
//    }
}
