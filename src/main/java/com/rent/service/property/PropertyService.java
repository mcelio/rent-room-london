package com.rent.service.property;

import com.rent.domainobject.PropertyDO;
import com.rent.exception.ConstraintsViolationException;
import com.rent.exception.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface PropertyService {

  PropertyDO find(Long id) throws EntityNotFoundException;

  Iterable<PropertyDO> findAll();

  PropertyDO create(PropertyDO propertyDO) throws ConstraintsViolationException;

  void delete(Long id) throws EntityNotFoundException;

  Page<PropertyDO> search(Specification<PropertyDO> specification, Pageable pageable);

}
