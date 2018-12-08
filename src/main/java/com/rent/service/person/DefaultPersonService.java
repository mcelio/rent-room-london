package com.rent.service.person;

import com.rent.dataaccessobject.PersonRepository;
import com.rent.domainobject.PersonDO;
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
 * person specific things.
 * <p/>
 */
@Service
public class DefaultPersonService implements PersonService {

  private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultPersonService.class);

  private final PersonRepository personRepository;

  public DefaultPersonService(final PersonRepository personRepository) {
    this.personRepository = personRepository;
  }


  /**
   * Selects a person by id.
   *
   * @return found person
   * @throws EntityNotFoundException if no person with the given id was found.
   */
  @Override
  public PersonDO find(Long id) throws EntityNotFoundException {
    return findPersonChecked(id);
  }


  /**
   * Creates a new person.
   *
   * @throws ConstraintsViolationException if a person already exists with the given id, ...
   * .
   */
  @Override
  public PersonDO create(PersonDO personDO) throws ConstraintsViolationException {
    PersonDO person;
    try {
      person = personRepository.save(personDO);
    } catch (DataIntegrityViolationException e) {
      LOG.warn("Some constraints are thrown due to person creation", e);
      throw new ConstraintsViolationException(e.getMessage());
    }
    return person;
  }


  /**
   * Deletes an existing person by id.
   *
   * @throws EntityNotFoundException if no person with the given id was found.
   */
  @Override
  @Transactional
  public void delete(Long id) throws EntityNotFoundException {
    PersonDO personDO = findPersonChecked(id);
    personDO.setDeleted(true);
  }



  private PersonDO findPersonChecked(Long id) throws EntityNotFoundException {
    PersonDO personDO = personRepository.findOne(id);
    if (personDO == null) {
      throw new EntityNotFoundException("Could not find entity with id: " + id);
    }
    return personDO;
  }

  @Override
  public Page<PersonDO> search(Specification<PersonDO> specification, Pageable pageable) {
    return null;
  }

  @Override
  public Iterable<PersonDO> findAll() {
    return personRepository.findAll();
  }
}
