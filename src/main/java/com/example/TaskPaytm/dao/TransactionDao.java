package com.example.TaskPaytm.dao;

import com.example.TaskPaytm.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface TransactionDao extends JpaRepository<Transaction, Long> {

}
