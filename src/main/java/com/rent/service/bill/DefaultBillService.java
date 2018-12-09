package com.rent.service.bill;

import com.rent.dataaccessobject.BillRepository;
import com.rent.domainobject.BillDO;
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
 * bill specific things.
 * <p/>
 */
@Service
public class DefaultBillService implements BillService {

  private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultBillService.class);

  private final BillRepository billRepository;

  public DefaultBillService(final BillRepository billRepository) {
    this.billRepository = billRepository;
  }


  /**
   * Selects a bill by id.
   *
   * @return found bill
   * @throws EntityNotFoundException if no bill with the given id was found.
   */
  @Override
  public BillDO find(Long id) throws EntityNotFoundException {
    return findBillChecked(id);
  }


  /**
   * Creates a new bill.
   *
   * @throws ConstraintsViolationException if a bill already exists with the given id, ...
   * .
   */
  @Override
  public BillDO create(BillDO billDO) throws ConstraintsViolationException {
    BillDO bill;
    try {
      bill = billRepository.save(billDO);
    } catch (DataIntegrityViolationException e) {
      LOG.warn("Some constraints are thrown due to bill creation", e);
      throw new ConstraintsViolationException(e.getMessage());
    }
    return bill;
  }


  /**
   * Deletes an existing bill by id.
   *
   * @throws EntityNotFoundException if no bill with the given id was found.
   */
  @Override
  @Transactional
  public void delete(Long id) throws EntityNotFoundException {
    BillDO billDO = findBillChecked(id);
    billDO.setDeleted(true);
  }



  private BillDO findBillChecked(Long id) throws EntityNotFoundException {
    BillDO billDO = billRepository.findOne(id);
    if (billDO == null) {
      throw new EntityNotFoundException("Could not find entity with id: " + id);
    }
    return billDO;
  }

  @Override
  public Page<BillDO> search(Specification<BillDO> specification, Pageable pageable) {
    return null;
  }

  @Override
  public Iterable<BillDO> findAll() {
    return billRepository.findAll();
  }
}
