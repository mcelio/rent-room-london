package com.rent.dataaccessobject;

import com.rent.domainobject.BillDO;
import com.rent.domainobject.PaymentDO;
import org.springframework.data.repository.CrudRepository;

/**
 * Database Access Object for bill table.
 * <p/>
 */
public interface BillRepository extends CrudRepository<BillDO, Long> {

}