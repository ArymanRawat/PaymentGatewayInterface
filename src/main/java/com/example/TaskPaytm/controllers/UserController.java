package com.example.TaskPaytm.controllers;

import com.example.TaskPaytm.dao.UserDao;
import com.example.TaskPaytm.exceptionHandling.ResourceNotFoundException;
import com.example.TaskPaytm.models.Merchant;
import com.example.TaskPaytm.models.User;
import com.example.TaskPaytm.models.Wallet;
import com.example.TaskPaytm.services.UserServices;
import com.example.TaskPaytm.services.WalletService;
import com.example.TaskPaytm.utilites.IsPostValid;
import com.example.TaskPaytm.utilites.UtilityMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

////    change --> adding a wallet to registered user
    @Autowired
    private WalletService walletService;

    @Autowired
    private UserServices userService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping("/user/all")
    public ArrayList<User> getAllUsers() {

        logger.log(Level.INFO, "list of all users returned at " + UtilityMethods.getCurrentTime());
        return (ArrayList<User>) this.userDao.findAll();

    }

    @GetMapping("/user/{uid}")
    public User getUserById(@PathVariable long uid) {

//        try {
//            return this.userDao.findById(uid);
//        } catch (Exception e){
//            return new ResourceNotFoundException("user not Found with id : " + userId));
//        }

        return this.userDao.findById(uid).orElseThrow(() -> new ResourceNotFoundException("user not Found with id : " + uid));
    }

    @PostMapping("/addUser")
    public User createUser(@RequestBody User user) {
        IsPostValid.postResponseMessageUser(user, userDao);
        logger.log(Level.INFO, user.toString());
        return this.userDao.save(user);
    }

//    change --> adding merchant registration
    @PostMapping("/merchant/register")
    public User registerMerchant(@RequestBody User user){
        IsPostValid.postResponseMessageUser(user, userDao);
        User registeredUser = this.userDao.save(user);

        Wallet newWallet = walletService.createWallet(user.getMobile());
        IsPostValid.walletPostValidate(newWallet, userService, walletService);
        newWallet.setCustomer(false);
        newWallet.setHaswallet(true);
        walletService.save(newWallet);
        newWallet.setCustomer(false);
        this.walletService.save(newWallet);

//        user.setHasWallet(walletService.addWallet(user.getMobile()));
        return registeredUser;
//        return newWallet;
    }

    @PostMapping("/user/register")
    public User createCustomereWallet(@RequestBody User user) {// we will be requiring request body to get data to fill

        IsPostValid.postResponseMessageUser(user, userDao);
        User registeredUser = this.userDao.save(user);

        Wallet newWallet = walletService.createWallet(user.getMobile());
        IsPostValid.walletPostValidate(newWallet, userService, walletService);
        newWallet.setCustomer(false);
        newWallet.setHaswallet(true);
        walletService.save(newWallet);

        return registeredUser;

    }

}
