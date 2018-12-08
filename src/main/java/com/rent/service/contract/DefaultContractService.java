package com.rent.service.contract;

import com.rent.dataaccessobject.ContractRepository;
import com.rent.domainobject.ContractDO;
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
 * contract specific things.
 * <p/>
 */
@Service
public class DefaultContractService implements ContractService {

  private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultContractService.class);

  private final ContractRepository contractRepository;

  public DefaultContractService(final ContractRepository contractRepository) {
    this.contractRepository = contractRepository;
  }


  /**
   * Selects a contract by id.
   *
   * @return found contract
   * @throws EntityNotFoundException if no contract with the given id was found.
   */
  @Override
  public ContractDO find(Long id) throws EntityNotFoundException {
    return findContractChecked(id);
  }


  /**
   * Creates a new contract.
   *
   * @throws ConstraintsViolationException if a contract already exists with the given id, ...
   * .
   */
  @Override
  public ContractDO create(ContractDO contractDO) throws ConstraintsViolationException {
    ContractDO contract;
    try {
      contract = contractRepository.save(contractDO);
    } catch (DataIntegrityViolationException e) {
      LOG.warn("Some constraints are thrown due to contract creation", e);
      throw new ConstraintsViolationException(e.getMessage());
    }
    return contract;
  }


  /**
   * Deletes an existing contract by id.
   *
   * @throws EntityNotFoundException if no contract with the given id was found.
   */
  @Override
  @Transactional
  public void delete(Long id) throws EntityNotFoundException {
    ContractDO contractDO = findContractChecked(id);
    contractDO.setDeleted(true);
  }



  private ContractDO findContractChecked(Long id) throws EntityNotFoundException {
    ContractDO contractDO = contractRepository.findOne(id);
    if (contractDO == null) {
      throw new EntityNotFoundException("Could not find entity with id: " + id);
    }
    return contractDO;
  }

  @Override
  public Page<ContractDO> search(Specification<ContractDO> specification, Pageable pageable) {
    return null;
  }

  @Override
  public Iterable<ContractDO> findAll() {
    return contractRepository.findAll();
  }
}
