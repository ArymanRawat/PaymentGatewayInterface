package com.example.TaskPaytm.services;

import com.example.TaskPaytm.dao.WalletDao;
import com.example.TaskPaytm.models.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    @Autowired
    private WalletDao walletDao;

    public void save(Wallet wallet) {
        walletDao.save(wallet);
    }

//    public boolean addWallet(long mobile){
//        return walletDao.addWallet(mobile).isHaswallet();
//    }

    public Wallet createWallet(long mobile){
        Wallet newWallet = new Wallet(mobile);
        walletDao.save(newWallet);
        return newWallet;
    }

    public List<Wallet> findByMobileWallet(long mobileWallet) {
        return walletDao.findByMobileWallet(mobileWallet);
    }

}
