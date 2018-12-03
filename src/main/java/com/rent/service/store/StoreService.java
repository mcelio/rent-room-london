package com.rent.service.store;

import com.rent.domainobject.StoreDO;
import com.rent.exception.ConstraintsViolationException;
import com.rent.exception.EntityNotFoundException;

public interface StoreService {

  StoreDO find(Long id) throws EntityNotFoundException;

  StoreDO create(StoreDO storeDO) throws ConstraintsViolationException;

  void delete(Long id) throws EntityNotFoundException;

  void updateLocation(long id, double longitude, double latitude)
      throws EntityNotFoundException;

  Iterable<StoreDO> findAll();
}
