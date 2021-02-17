package com.daniel.flapperapp;

import com.daniel.flapperapp.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

   public Optional<Student> findByPhonenumber(int phonenumber);

   public Optional<Student> findByGender(String gender);

   public Optional<Student> deleteByPhonenumber(int phonenumber);

   public Optional<Student> findByEmail (String email);

}
