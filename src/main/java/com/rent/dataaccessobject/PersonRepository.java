package com.rent.dataaccessobject;

import com.rent.domainobject.PersonDO;
import org.springframework.data.repository.CrudRepository;

/**
 * Database Access Object for person table.
 * <p/>
 */
public interface PersonRepository extends CrudRepository<PersonDO, Long> {

}