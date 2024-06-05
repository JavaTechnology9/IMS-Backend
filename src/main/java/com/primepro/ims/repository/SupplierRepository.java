package com.primepro.ims.repository;

import com.primepro.ims.model.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier,Long> {

    Optional<Supplier> findBySupplierName(String supplierName);
}
