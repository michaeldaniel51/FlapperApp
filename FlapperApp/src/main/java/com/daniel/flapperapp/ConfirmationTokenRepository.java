package com.daniel.flapperapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConfirmationTokenRepository extends CrudRepository <ConfirmationToken,Long> {


}
