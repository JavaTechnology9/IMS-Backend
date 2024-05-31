package com.primepro.ims.repository;

import com.primepro.ims.model.Product;
import com.primepro.ims.model.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
