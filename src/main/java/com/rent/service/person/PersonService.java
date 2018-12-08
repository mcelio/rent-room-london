package com.rent.service.person;

import com.rent.domainobject.PersonDO;
import com.rent.exception.ConstraintsViolationException;
import com.rent.exception.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;

public interface PersonService {

  PersonDO find(Long id) throws EntityNotFoundException;

  Iterable<PersonDO> findAll();

  PersonDO create(PersonDO personDO) throws ConstraintsViolationException;

  void delete(Long id) throws EntityNotFoundException;

  Page<PersonDO> search(Specification<PersonDO> specification, Pageable pageable);

}
