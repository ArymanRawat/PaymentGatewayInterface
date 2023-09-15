package com.example.TaskPaytm.models;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tid;


    @Column(name = "receiverNo")
    private Long receiverNo;


    @Column(name = "senderNo")
    private Long senderNo;


    @Column(name = "amount")
    private Long amount;


    @Column(name = "status")
    private boolean status;


    @Column(name = "mode")
    private String mode;

    @Column(name = "time")
    private String time;

//    private long senderId;


    public Transaction(){

    }

    public Transaction(Long receiverNo, Long senderNo, Long amount) {
        super();
        this.receiverNo = receiverNo;
        this.senderNo = senderNo;
        this.amount = amount;
    }

    public long getUid() {
        return tid;
    }

    public void setUid(long tid) {
        this.tid = tid;
    }

    public Long getReceiverNo() {
        return receiverNo;
    }

    public void setReceiverNo(Long receiverNo) {
        this.receiverNo = receiverNo;
    }

    public Long getSenderNo() {
        return senderNo;
    }

    public void setSenderNo(Long senderNo) {
        this.senderNo = senderNo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tid=" + tid +
                ", receiverNo=" + receiverNo +
                ", senderNo=" + senderNo +
                ", amount=" + amount +
                ", status=" + status +
                ", mode='" + mode + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
