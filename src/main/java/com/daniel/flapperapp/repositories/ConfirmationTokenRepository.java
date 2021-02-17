package com.daniel.flapperapp.repositories;

import com.daniel.flapperapp.entities.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConfirmationTokenRepository extends CrudRepository <ConfirmationToken,Long> {


}
