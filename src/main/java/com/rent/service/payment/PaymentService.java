package com.rent.service.payment;

import com.rent.domainobject.PaymentDO;
import com.rent.exception.ConstraintsViolationException;
import com.rent.exception.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface PaymentService {

  PaymentDO find(Long id) throws EntityNotFoundException;

  Iterable<PaymentDO> findAll();

  PaymentDO create(PaymentDO paymentDO) throws ConstraintsViolationException;

  void delete(Long id) throws EntityNotFoundException;

  Page<PaymentDO> search(Specification<PaymentDO> specification, Pageable pageable);

}
