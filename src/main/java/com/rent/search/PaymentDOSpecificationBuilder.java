package com.rent.search;

import com.rent.domainobject.PaymentDO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import java.util.ArrayList;
import java.util.List;

public class PaymentDOSpecificationBuilder {

  private final List<SearchCriteria> params;


  public PaymentDOSpecificationBuilder() {
    params = new ArrayList<SearchCriteria>();
  }


  public PaymentDOSpecificationBuilder with(String key, String operation, Object value) {
    params.add(new SearchCriteria(key, operation, value));
    return this;
  }


  public Specification<PaymentDO> build() {
    if (params.size() == 0) {
      return null;
    }

    List<Specification<PaymentDO>> specs = new ArrayList<Specification<PaymentDO>>();
    for (SearchCriteria param : params) {
      specs.add(new PaymentDOSpecification(param));
    }

    Specification<PaymentDO> result = specs.get(0);
    for (int i = 1; i < specs.size(); i++) {
      result = Specifications.where(result).and(specs.get(i));
    }
    return result;
  }
}
