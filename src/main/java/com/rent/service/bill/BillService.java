package com.rent.service.bill;

import com.rent.domainobject.BillDO;
import com.rent.exception.ConstraintsViolationException;
import com.rent.exception.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface BillService {

  BillDO find(Long id) throws EntityNotFoundException;

  Iterable<BillDO> findAll();

  BillDO create(BillDO billDO) throws ConstraintsViolationException;

  void delete(Long id) throws EntityNotFoundException;

  Page<BillDO> search(Specification<BillDO> specification, Pageable pageable);

}
