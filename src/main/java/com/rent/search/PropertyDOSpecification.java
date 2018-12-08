package com.rent.search;

import com.rent.domainobject.PropertyDO;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class PropertyDOSpecification implements Specification<PropertyDO> {

    private static final String STREET1 = "street1";
    private static final String STREET2 = "street2";
    private static final String STREET3 = "street3";
    private SearchCriteria criteria;


    public PropertyDOSpecification(final SearchCriteria criteria) {
        super();
        this.criteria = criteria;
    }


    @Override
    public Predicate toPredicate(Root<PropertyDO> root, CriteriaQuery<?> query,
                                 CriteriaBuilder builder) {
        String operation = criteria.getOperation();
        String field = criteria.getKey();
        Join<PropertyDO, PropertyDO> storeProperty = root.join("property");
        if (STREET1.equals(field)) {
            return builder.like(storeProperty.get(criteria.getKey()), "%" + criteria.getValue() + "%");
        } else if (STREET2.equals(field)) {
        } else if (STREET3.equals(field)) {
        }
        return null;
    }
}
