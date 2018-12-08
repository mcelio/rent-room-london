package com.rent.search;

import com.rent.domainobject.PaymentDO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class PaymentDOSpecification implements Specification<PaymentDO> {

  private static final String NAME = "name";
  private static final String PASSPORT_NUMBER = "passportNumber";
  private static final String EMAIL = "email";
  private SearchCriteria criteria;


  public PaymentDOSpecification(final SearchCriteria criteria) {
    super();
    this.criteria = criteria;
  }


  @Override
  public Predicate toPredicate(Root<PaymentDO> root, CriteriaQuery<?> query,
      CriteriaBuilder builder) {
    String operation = criteria.getOperation();
    String field = criteria.getKey();
    Join<PaymentDO, PaymentDO> storePayment = root.join("payment");
    if (NAME.equals(field)) {
      return builder.like(storePayment.get(criteria.getKey()), "%" + criteria.getValue() + "%");
    } else if (EMAIL.equals(field)) {
    }
    return null;
  }
}
