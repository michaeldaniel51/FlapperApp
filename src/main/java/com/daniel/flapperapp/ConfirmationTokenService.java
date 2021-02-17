package com.daniel.flapperapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfirmationTokenService {

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;


  public void saveConfirmationToken(ConfirmationToken confirmationToken){

        confirmationTokenRepository.save(confirmationToken);
    }

    public Optional<ConfirmationToken> findConfirmationTokenByToken(long token) {

        return confirmationTokenRepository.findById(token);
    }


    //   public void deleteConfirmationToken(long id) {
//
  //    confirmationTokenRepository.deleteById(id);
    //}
}
