package com.rent.dataaccessobject;

import com.rent.domainobject.PersonDO;
import com.rent.domainobject.PropertyDO;
import org.springframework.data.repository.CrudRepository;

/**
 * Database Access Object for porperty table.
 * <p/>
 */
public interface PropertyRepository extends CrudRepository<PropertyDO, Long> {

}