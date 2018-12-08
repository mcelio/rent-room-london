package com.rent.search;

import com.rent.domainobject.ContractDO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import java.util.ArrayList;
import java.util.List;

public class ContractDOSpecificationBuilder {

  private final List<SearchCriteria> params;


  public ContractDOSpecificationBuilder() {
    params = new ArrayList<SearchCriteria>();
  }


  public ContractDOSpecificationBuilder with(String key, String operation, Object value) {
    params.add(new SearchCriteria(key, operation, value));
    return this;
  }


  public Specification<ContractDO> build() {
    if (params.size() == 0) {
      return null;
    }

    List<Specification<ContractDO>> specs = new ArrayList<Specification<ContractDO>>();
    for (SearchCriteria param : params) {
      specs.add(new ContractDOSpecification(param));
    }

    Specification<ContractDO> result = specs.get(0);
    for (int i = 1; i < specs.size(); i++) {
      result = Specifications.where(result).and(specs.get(i));
    }
    return result;
  }
}
