package com.daniel.flapperapp.services;

import com.daniel.flapperapp.entities.Student;
import com.daniel.flapperapp.entities.Transaction;
import com.daniel.flapperapp.repositories.TransactionRepository;
import com.daniel.flapperapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    StudentService studentService;






    public Transaction deposit(Transaction transaction) {

        Student student = new Student();
        transaction.setStudent(student);
        int balance = transaction.getBalance();


        if (transaction.getAmount()!= 0) {
             balance = transaction.getBalance() + transaction.getAmount();
            int previoustransaction = +balance;

        }
        student.setBalance(balance);
        studentService.addStudent(student);
        return transactionRepository.save(transaction);

    }

    public Transaction withdraw(Transaction transaction){

        Student student= new Student();
        transaction.setStudent(student);
        int balance = transaction.getBalance();


        if(transaction.getAmount()!=0){
            balance = transaction.getBalance() - transaction.getAmount();
            int previoustransaction = -balance;


        }
        student.setBalance(balance);
        studentService.addStudent(student);
        return transactionRepository.save(transaction);
    }

    public Transaction getPreviousTransaction(Transaction transaction) {
        Student student = new Student();
        transaction.setStudent(student);
    int balance = student.getBalance();

        if(transaction.getAmount() > balance){
            return deposit(transaction);

        } else if (transaction.getAmount() < balance){
            return withdraw(transaction);
        }

        student.setBalance(balance);
        studentService.addStudent(student);
      return transactionRepository.save(transaction);
    }


    public Optional<Transaction> getTransactionById(int id){
        return transactionRepository.findById(id);
    }

}
