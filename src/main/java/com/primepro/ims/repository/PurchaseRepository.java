package com.primepro.ims.repository;

import com.primepro.ims.model.PurchaseInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<PurchaseInfo,Long> {
}
