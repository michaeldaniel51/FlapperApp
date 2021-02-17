package com.daniel.flapperapp.entities;


import com.daniel.flapperapp.entities.Student;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TRANSACTIONID")
    private int id = UUID.randomUUID().hashCode();

    @Column(name="AMOUNT")
    private int amount;
    private int balance;
    private int deposit;
    private int withdraw;
    private int previoustransaction;
    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public void setPrevioustransaction(int previoustransaction) {
        this.previoustransaction = previoustransaction;
    }

    public int getPrevioustransaction() {
        return previoustransaction;
    }



    @ManyToOne
    private Student student;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Transaction(int id, int amount, int balance, int deposit, int withdraw, int previoustransaction, String message, Student student) {
        this.id = id;
        this.amount = amount;
        this.balance = balance;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.previoustransaction = previoustransaction;
        this.message = message;
        this.student = student;
    }

    public Transaction() {
    }
}
