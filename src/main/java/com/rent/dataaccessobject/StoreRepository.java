package com.rent.dataaccessobject;

import com.rent.domainobject.StoreDO;
import org.springframework.data.repository.CrudRepository;

/**
 * Database Access Object for store table.
 * <p/>
 */
public interface StoreRepository extends CrudRepository<StoreDO, Long> {

}
