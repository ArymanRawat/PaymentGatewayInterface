package com.example.TaskPaytm.utilites;

import com.example.TaskPaytm.exceptionHandling.ResourceNotFoundException;
import com.example.TaskPaytm.models.Wallet;
import com.example.TaskPaytm.services.WalletService;

import java.util.List;

public class IsPutValidated {

    public static void canBalanceBeAddedWallet(WalletService walletService, Long mob,
                                               Wallet balanceWallet) {
        // find list of wallet by userID
        List<Wallet> wallets = walletService.findByMobileWallet(mob);

        // if wallet list is empty, user doesn't exist
        if (wallets.isEmpty()) {
            throw new ResourceNotFoundException("Wallet does not exist with this mobile number");
        }

        // getting wallet object from list and then balance
        Wallet wallet = wallets.get(0);
        if (!wallet.isHaswallet()) {
            throw new ResourceNotFoundException("Wallet is de-activated");
        }
        long balance = balanceWallet.getBalance();

    }

}
