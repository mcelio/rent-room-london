package com.rent.service.property;

import com.rent.dataaccessobject.PropertyRepository;
import com.rent.dataaccessobject.StoreRepository;
import com.rent.domainobject.PropertyDO;
import com.rent.exception.ConstraintsViolationException;
import com.rent.exception.EntityNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some
 * property specific things.
 * <p/>
 */
@Service
public class DefaultPropertyService implements PropertyService {

  private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DefaultPropertyService.class);

  private final PropertyRepository propertyRepository;

  public DefaultPropertyService(final PropertyRepository propertyRepository,
                                final StoreRepository storeRepository) {
    this.propertyRepository = propertyRepository;
  }


  /**
   * Selects a property by id.
   *
   * @return found property
   * @throws EntityNotFoundException if no property with the given id was found.
   */
  @Override
  public PropertyDO find(Long id) throws EntityNotFoundException {
    return findPropertyChecked(id);
  }


  /**
   * Creates a new property.
   *
   * @throws ConstraintsViolationException if a property already exists with the given id, ...
   * .
   */
  @Override
  public PropertyDO create(PropertyDO propertyDO) throws ConstraintsViolationException {
    PropertyDO property;
    try {
      property = propertyRepository.save(propertyDO);
    } catch (DataIntegrityViolationException e) {
      LOG.warn("Some constraints are thrown due to property creation", e);
      throw new ConstraintsViolationException(e.getMessage());
    }
    return property;
  }


  /**
   * Deletes an existing property by id.
   *
   * @throws EntityNotFoundException if no property with the given id was found.
   */
  @Override
  @Transactional
  public void delete(Long id) throws EntityNotFoundException {
    PropertyDO propertyDO = findPropertyChecked(id);
    propertyDO.setDeleted(true);
  }



  private PropertyDO findPropertyChecked(Long id) throws EntityNotFoundException {
    PropertyDO propertyDO = propertyRepository.findOne(id);
    if (propertyDO == null) {
      throw new EntityNotFoundException("Could not find entity with id: " + id);
    }
    return propertyDO;
  }

  @Override
  public Page<PropertyDO> search(Specification<PropertyDO> specification, Pageable pageable) {
    return null;
  }

  @Override
  public Iterable<PropertyDO> findAll() {
    return propertyRepository.findAll();
  }
}
