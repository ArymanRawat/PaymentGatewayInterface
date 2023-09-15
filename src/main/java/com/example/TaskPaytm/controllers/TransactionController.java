package com.example.TaskPaytm.controllers;

import com.example.TaskPaytm.exceptionHandling.ResourceNotFoundException;
import com.example.TaskPaytm.models.Transaction;
import com.example.TaskPaytm.models.Wallet;
import com.example.TaskPaytm.services.TransactionService;
import com.example.TaskPaytm.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.TaskPaytm.utilites.UtilityMethods.getCurrentTime;

@Transactional
@RestController
public class TransactionController {

    @Autowired                         //dependency injection
    TransactionService transactionService;
    @Autowired                         //dependency injection
    WalletService walletService;

    @GetMapping(value = "/transaction/all")
    public List<Transaction> displayAll() {
        return transactionService.displayall();
    }

    @GetMapping(value = "/transaction/status/{transactionid}")
    public String displayTransaction(@PathVariable Long transactionid) {
        Transaction checkTransaction = transactionService.get(transactionid);
        if (checkTransaction==null)
        {
            return "No such transaction made";
        }
        else if(!checkTransaction.isStatus())
        {
            return "Transaction Status: failed";
        }

        else return "Transaction Status: Successful";
    }


    @PostMapping("/transaction/initiate")
    public Transaction addtransaction(@RequestBody Transaction transModel) {
        Wallet sender =walletService.findByMobileWallet(transModel.getSenderNo()).get(0);
        Wallet receiver =walletService.findByMobileWallet(transModel.getReceiverNo()).get(0);

        transModel.setStatus(false);
        transModel.setTime(getCurrentTime());
        transModel.setMode("online");
        if(sender==null) {
            throw new ResourceNotFoundException("sender do not exist");
        }
        else if(receiver==null) {
            throw new ResourceNotFoundException("receiver do not exist");
        }
        else if(sender.getBalance() < transModel.getAmount()) {
            transactionService.save(transModel);

//            throw new ResourceNotFoundException("Insufficient balance of sender");
            return transModel;
            //return "Insufficient balance";
        }
//
        ////////////////////
        long preSender=sender.getBalance();
        long preReceiver=receiver.getBalance();
        preSender=preSender-transModel.getAmount();
        preReceiver=preReceiver+transModel.getAmount();
        sender.setBalance(preSender);
        receiver.setBalance(preReceiver);
        this.walletService.save(sender);
        this.walletService.save(receiver);
        transModel.setStatus(true);
        transactionService.save(transModel);
        ////////////////////////
        return transModel;
    }

}
