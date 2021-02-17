package com.daniel.flapperapp;

import com.daniel.flapperapp.entities.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TransactionRepository extends CrudRepository<Transaction,Integer> {


    Optional<Transaction> findById(int id);

}
