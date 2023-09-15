package com.example.TaskPaytm.dao;

import com.example.TaskPaytm.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface WalletDao extends JpaRepository<Wallet, Long> {

    public List<Wallet> findByMobileWallet(long mobileWallet);

//    public Wallet addWallet(long mobile);

}
