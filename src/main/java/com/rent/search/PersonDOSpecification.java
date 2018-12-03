package com.rent.search;

import com.rent.domainobject.PersonDO;
import com.rent.domainobject.StoreDO;
import com.rent.domainvalue.StoreType;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class PersonDOSpecification implements Specification<PersonDO> {

  private static final String NAME = "name";
  private static final String PASSPORT_NUMBER = "passportNumber";
  private static final String EMAIL = "email";
  private SearchCriteria criteria;


  public PersonDOSpecification(final SearchCriteria criteria) {
    super();
    this.criteria = criteria;
  }


  @Override
  public Predicate toPredicate(Root<PersonDO> root, CriteriaQuery<?> query,
      CriteriaBuilder builder) {
    String operation = criteria.getOperation();
    String field = criteria.getKey();
    Join<PersonDO, StoreDO> storePerson = root.join("person");
    if (NAME.equals(field)) {
      return builder.like(storePerson.get(criteria.getKey()), "%" + criteria.getValue() + "%");
    } else if (EMAIL.equals(field)) {
    }
    return null;
  }
}
