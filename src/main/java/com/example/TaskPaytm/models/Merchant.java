package com.example.TaskPaytm.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "merchant")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mid;

    @NotNull
//    @Size(min = 2, message = "First Name should have atelast 2 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotNull
//    @Size(min = 2, message = "Last Name should have at least 2 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "mobile_no", length = 10)
    private Long mobile_no;

    //    @NotBlank
//    @Email
    @Column(name = "email_id")
    private String email_id;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;


    @Column(name = "haswallet")
    private boolean haswallet;

    @Column(name = "wallet_id")
    private long wallet_id;

    @Column(name = "gender")
    private String gender;

    public Merchant() {
    }

    public Merchant(String firstName, String lastName, String email, String address1, String address2, long mobile, String gender, long walletId) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email_id = email;
        this.address1 = address1;
        this.address2 = address2;
        this.mobile_no = mobile;
        this.gender = gender;
        this.haswallet = false;
//        this.balance = 0;
        this.wallet_id = walletId;

    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
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

    public Long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(Long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
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

    public boolean isHaswallet() {
        return haswallet;
    }

    public void setHaswallet(boolean haswallet) {
        this.haswallet = haswallet;
    }

    public long getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(long wallet_id) {
        this.wallet_id = wallet_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "mid=" + mid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile_no=" + mobile_no +
                ", email_id='" + email_id + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", haswallet=" + haswallet +
                ", wallet_id=" + wallet_id +
                ", gender='" + gender + '\'' +
                '}';
    }
}
