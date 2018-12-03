package com.rent.service.product;

import com.rent.domainobject.ProductDO;
import com.rent.domainvalue.ProductType;
import com.rent.exception.ConstraintsViolationException;
import com.rent.exception.EntityNotFoundException;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ProductService {

  ProductDO find(Long id) throws EntityNotFoundException;

  ProductDO create(ProductDO productDO) throws ConstraintsViolationException;

  void delete(Long id) throws EntityNotFoundException;

  List<ProductDO> find(ProductType productType);

  Page<ProductDO> search(Specification<ProductDO> specification, Pageable pageable);

}
