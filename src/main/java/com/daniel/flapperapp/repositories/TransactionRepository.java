package com.daniel.flapperapp.repositories;

import com.daniel.flapperapp.entities.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TransactionRepository extends CrudRepository<Transaction,Integer> {


    Optional<Transaction> findById(int id);

}
