package com.rent.search;

import com.rent.domainobject.ContractDO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class ContractDOSpecification implements Specification<ContractDO> {

  private static final String NAME = "name";
  private static final String PASSPORT_NUMBER = "passportNumber";
  private static final String EMAIL = "email";
  private SearchCriteria criteria;


  public ContractDOSpecification(final SearchCriteria criteria) {
    super();
    this.criteria = criteria;
  }


  @Override
  public Predicate toPredicate(Root<ContractDO> root, CriteriaQuery<?> query,
      CriteriaBuilder builder) {
    String operation = criteria.getOperation();
    String field = criteria.getKey();
    Join<ContractDO, ContractDO> storeContract = root.join("contract");
    if (NAME.equals(field)) {
      return builder.like(storeContract.get(criteria.getKey()), "%" + criteria.getValue() + "%");
    } else if (EMAIL.equals(field)) {
    }
    return null;
  }
}
