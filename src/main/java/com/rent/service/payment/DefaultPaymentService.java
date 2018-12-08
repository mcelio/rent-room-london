package com.rent.service.payment;

import com.rent.dataaccessobject.PaymentRepository;
import com.rent.domainobject.PaymentDO;
import com.rent.exception.ConstraintsViolationException;
import com.rent.exception.EntityNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some
 * payment specific things.
 * <p/>
 */
@Service
public class DefaultPaymentService implements PaymentService {

  private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultPaymentService.class);

  private final PaymentRepository paymentRepository;

  public DefaultPaymentService(final PaymentRepository paymentRepository) {
    this.paymentRepository = paymentRepository;
  }


  /**
   * Selects a payment by id.
   *
   * @return found payment
   * @throws EntityNotFoundException if no payment with the given id was found.
   */
  @Override
  public PaymentDO find(Long id) throws EntityNotFoundException {
    return findPaymentChecked(id);
  }


  /**
   * Creates a new payment.
   *
   * @throws ConstraintsViolationException if a payment already exists with the given id, ...
   * .
   */
  @Override
  public PaymentDO create(PaymentDO paymentDO) throws ConstraintsViolationException {
    PaymentDO payment;
    try {
      payment = paymentRepository.save(paymentDO);
    } catch (DataIntegrityViolationException e) {
      LOG.warn("Some constraints are thrown due to payment creation", e);
      throw new ConstraintsViolationException(e.getMessage());
    }
    return payment;
  }


  /**
   * Deletes an existing payment by id.
   *
   * @throws EntityNotFoundException if no payment with the given id was found.
   */
  @Override
  @Transactional
  public void delete(Long id) throws EntityNotFoundException {
    PaymentDO paymentDO = findPaymentChecked(id);
    paymentDO.setDeleted(true);
  }



  private PaymentDO findPaymentChecked(Long id) throws EntityNotFoundException {
    PaymentDO paymentDO = paymentRepository.findOne(id);
    if (paymentDO == null) {
      throw new EntityNotFoundException("Could not find entity with id: " + id);
    }
    return paymentDO;
  }

  @Override
  public Page<PaymentDO> search(Specification<PaymentDO> specification, Pageable pageable) {
    return null;
  }

  @Override
  public Iterable<PaymentDO> findAll() {
    return paymentRepository.findAll();
  }
}
