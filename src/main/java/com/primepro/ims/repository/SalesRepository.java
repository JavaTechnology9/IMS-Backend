package com.primepro.ims.repository;

import com.primepro.ims.model.SalesInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends CrudRepository<SalesInfo, Long> {
}
