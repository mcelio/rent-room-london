package com.rent.search;

import com.rent.domainobject.PropertyDO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import java.util.ArrayList;
import java.util.List;

public class PropertyDOSpecificationBuilder {

  private final List<SearchCriteria> params;


  public PropertyDOSpecificationBuilder() {
    params = new ArrayList<SearchCriteria>();
  }


  public PropertyDOSpecificationBuilder with(String key, String operation, Object value) {
    params.add(new SearchCriteria(key, operation, value));
    return this;
  }


  public Specification<PropertyDO> build() {
    if (params.size() == 0) {
      return null;
    }

    List<Specification<PropertyDO>> specs = new ArrayList<Specification<PropertyDO>>();
    for (SearchCriteria param : params) {
      specs.add(new PropertyDOSpecification(param));
    }

    Specification<PropertyDO> result = specs.get(0);
    for (int i = 1; i < specs.size(); i++) {
      result = Specifications.where(result).and(specs.get(i));
    }
    return result;
  }
}
