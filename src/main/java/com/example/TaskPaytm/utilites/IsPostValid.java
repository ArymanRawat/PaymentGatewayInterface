package com.example.TaskPaytm.utilites;

import com.example.TaskPaytm.dao.UserDao;
import com.example.TaskPaytm.exceptionHandling.ResourceNotFoundException;
import com.example.TaskPaytm.models.User;
import com.example.TaskPaytm.models.Wallet;
import com.example.TaskPaytm.services.UserServices;
import com.example.TaskPaytm.services.WalletService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IsPostValid {

    private static Logger logger = Logger.getLogger("PostValidator");

    public static boolean isEmailValidated(String emailId, UserDao userDao) {
        return userDao.findByEmail(emailId).isEmpty();
    }

    public static boolean isMobileNumberValidated(long mobileNo, UserDao userDao) {
        if (mobileNo == 0) return true;
        return userDao.findByMobile(mobileNo).isEmpty();
    }

    public static void postResponseMessageUser(User user, UserDao userDao) {
        Logger logger = Logger.getLogger(user.getClass().getName());



        if (user.getFirstName() == null) {
            logger.log(Level.INFO, "undesired input");
            throw new ResourceNotFoundException("Firstname cannot be empty");
        } else if (user.getLastName() == null) {
            logger.log(Level.INFO, "undesired input");
            throw new ResourceNotFoundException("Lastname cannot be empty");
        }else if(user.getEmail() == null){
            logger.log(Level.INFO, "undesired input");
            throw new ResourceNotFoundException("Email cannot be empty");
        }else if (!isEmailValidated(user.getEmail(), userDao)) {
            logger.log(Level.INFO, "undesired input");
            throw new ResourceNotFoundException("User with an identical email already exists");

        } else if (!isMobileNumberValidated(user.getMobile(), userDao)) {
            logger.log(Level.INFO, "undesired input");
            throw new ResourceNotFoundException("User with an identical mobile number already exists");
        }
        // else return "";//returning no error
    }

    public static void walletPostValidate(Wallet walletBody, UserServices userService, WalletService walletService) {
        //information cannot be null byDefault as using table such a way
        // if mobile number we get from request body is 0
        if(walletBody.getMobileWallet()==0 || walletBody.getMobileWallet()==null){
            throw new ResourceNotFoundException("mobile number field cannot be empty");
        }


        // getting a list of user with the specified mobile number
        List<User> listUsers = userService.findByMobile(walletBody.getMobileWallet());
        if (listUsers.isEmpty()) {
            //throw no such user exist
            throw new ResourceNotFoundException("No user with this mobile exist");

        }
        List<Wallet> listWallet = walletService.findByMobileWallet(walletBody.getMobileWallet());
        if (listWallet.size() > 1) {
            //throw Wallet already exist
            throw new ResourceNotFoundException("Wallet already exist with this mobile");

        }

        return;
    }

}
