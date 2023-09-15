package com.example.TaskPaytm.controllers;

import com.example.TaskPaytm.dao.WalletDao;
import com.example.TaskPaytm.exceptionHandling.ResourceNotFoundException;
import com.example.TaskPaytm.models.User;
import com.example.TaskPaytm.models.Wallet;
import com.example.TaskPaytm.services.UserServices;
import com.example.TaskPaytm.services.WalletService;
import com.example.TaskPaytm.utilites.IsPostValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.TaskPaytm.utilites.IsPutValidated.canBalanceBeAddedWallet;

@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;
    @Autowired
    private WalletDao walletDao;
//    @Autowired
//    private UserServices userService;
    private Logger logger = Logger.getLogger(this.getClass().getName());


    @PutMapping("/user/add/money/{amount}")
    public Wallet ChangeWalletBalance(@RequestBody Wallet walletBody, @PathVariable(value = "amount") long bal) {

        long num = walletBody.getMobileWallet();
        canBalanceBeAddedWallet(walletService,num,walletBody);

        List<Wallet> existingUsers = this.walletDao.findByMobileWallet(num);
        if (existingUsers == null) {
            throw new ResourceNotFoundException("user not Found with number : " + num);
        }
        Wallet existingUser = existingUsers.get(0);
        long pre_bal = existingUser.getBalance();
        existingUser.setBalance(bal + pre_bal);
        logger.log(Level.INFO, walletBody.toString());
        return this.walletDao.save(existingUser);//this will directly save into database
    }


}
