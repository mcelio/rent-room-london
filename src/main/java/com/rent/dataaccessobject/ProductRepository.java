package com.rent.dataaccessobject;

import com.rent.domainobject.ProductDO;
import com.rent.domainvalue.ProductType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Database Access Object for product table.
 * <p/>
 */
public interface ProductRepository extends CrudRepository<ProductDO, Long>,
    JpaSpecificationExecutor<ProductDO> {

  List<ProductDO> findByProductType(ProductType productType);
}
