package com.rent.dataaccessobject;

import com.rent.domainobject.PaymentDO;
import com.rent.domainobject.PersonDO;
import org.springframework.data.repository.CrudRepository;

/**
 * Database Access Object for Payment table.
 * <p/>
 */
public interface PaymentRepository extends CrudRepository<PaymentDO, Long> {

}