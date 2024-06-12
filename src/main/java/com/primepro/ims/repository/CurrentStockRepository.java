package com.primepro.ims.repository;

import com.primepro.ims.model.CurrentStock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentStockRepository extends CrudRepository<CurrentStock,Long> {
}
