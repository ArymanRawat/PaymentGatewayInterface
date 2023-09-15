package com.example.TaskPaytm.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "mobile", length = 10)
    private Long mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "hasWallet")
    private boolean hasWallet;

//    @Column(name = "wallet_id")
//    private long wallet_id;

    @Column(name = "gender")
    private String gender;

//    @Column(name = "balance")
//    private long balance;

    @Column(name = "isMerchant")
    private boolean isMerchant;

    public User() {
    }

    public User(String firstName, String lastName, String email, String address1, String address2, long mobile, String gender, boolean isMerchant) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.mobile = mobile;
        this.gender = gender;
        this.hasWallet = false;
        this.isMerchant = isMerchant;

    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email= email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public boolean getHasWallet() {
        return hasWallet;
    }

    public void setHasWallet(boolean hasWallet) {
        this.hasWallet = hasWallet;
    }

    public boolean isHasWallet() {
        return hasWallet;
    }

//    public long getBalance() {
//        return balance;
//    }

//    public void setBalance(long balance) {
//        this.balance = balance;
//    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    public long getWallet_id() {
//        return wallet_id;
//    }

//    public void setWallet_id(long wallet_id) {
//        this.wallet_id = wallet_id;
//    }


//  change -->  adding getter and setter for isMerchant field;
    public boolean getIsMerchant() {
        return isMerchant;
    }

    public void setMerchant(boolean merchant) {
        isMerchant = merchant;
    }
}
