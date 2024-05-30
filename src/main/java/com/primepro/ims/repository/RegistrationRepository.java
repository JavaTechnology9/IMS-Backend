package com.primepro.ims.repository;

import com.primepro.ims.model.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Long> {

    Optional<Registration> findByUsername(String username);
}
