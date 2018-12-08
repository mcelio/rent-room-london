package com.rent.dataaccessobject;

import com.rent.domainobject.ContractDO;
import org.springframework.data.repository.CrudRepository;

/**
 * Database Access Object for contract table.
 * <p/>
 */
public interface ContractRepository extends CrudRepository<ContractDO, Long> {

}