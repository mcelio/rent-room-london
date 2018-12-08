package com.rent.service.contract;

import com.rent.domainobject.ContractDO;
import com.rent.exception.ConstraintsViolationException;
import com.rent.exception.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ContractService {

  ContractDO find(Long id) throws EntityNotFoundException;

  Iterable<ContractDO> findAll();

  ContractDO create(ContractDO contractDO) throws ConstraintsViolationException;

  void delete(Long id) throws EntityNotFoundException;

  Page<ContractDO> search(Specification<ContractDO> specification, Pageable pageable);

}
