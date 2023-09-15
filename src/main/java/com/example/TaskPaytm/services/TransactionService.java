package com.example.TaskPaytm.services;

import com.example.TaskPaytm.dao.TransactionDao;
import com.example.TaskPaytm.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    public void save(Transaction transaction) {
        transactionDao.save(transaction);
    }

    public Transaction get(Long id) {
        return transactionDao.findById(id).get();
    }

    public List<Transaction> displayall() {
        return transactionDao.findAll();
    }

}
