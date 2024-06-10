package com.primepro.ims.repository;

import com.primepro.ims.model.Login;
import com.primepro.ims.model.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends CrudRepository<Login,Long> {
    Optional<Login> findByUsername(String username);
}
