package com.rent.search;

import com.rent.domainobject.PersonDO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import java.util.ArrayList;
import java.util.List;

public class PersonDOSpecificationBuilder {

  private final List<SearchCriteria> params;


  public PersonDOSpecificationBuilder() {
    params = new ArrayList<SearchCriteria>();
  }


  public PersonDOSpecificationBuilder with(String key, String operation, Object value) {
    params.add(new SearchCriteria(key, operation, value));
    return this;
  }


  public Specification<PersonDO> build() {
    if (params.size() == 0) {
      return null;
    }

    List<Specification<PersonDO>> specs = new ArrayList<Specification<PersonDO>>();
    for (SearchCriteria param : params) {
      specs.add(new PersonDOSpecification(param));
    }

    Specification<PersonDO> result = specs.get(0);
    for (int i = 1; i < specs.size(); i++) {
      result = Specifications.where(result).and(specs.get(i));
    }
    return result;
  }
}
