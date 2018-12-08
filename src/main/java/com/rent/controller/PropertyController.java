package com.rent.controller;

import com.rent.controller.mapper.PropertyMapper;
import com.rent.datatransferobject.PropertyDTO;
import com.rent.domainobject.PropertyDO;
import com.rent.exception.ConstraintsViolationException;
import com.rent.exception.EntityNotFoundException;
import com.rent.search.PropertyDOSpecificationBuilder;
import com.rent.service.property.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * All operations with a property will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/propertys")
public class PropertyController {

  private final PropertyService propertyService;


  @Autowired
  public PropertyController(final PropertyService propertyService) {
    this.propertyService = propertyService;
  }


  @GetMapping("/{propertyId}")
  public PropertyDTO getDriver(@Valid @PathVariable long propertyId) throws EntityNotFoundException {
    return PropertyMapper.makePropertyDTO(propertyService.find(propertyId));
  }


  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PropertyDTO createProperty(@Valid @RequestBody PropertyDTO propertyDTO)
      throws ConstraintsViolationException {
    PropertyDO propertyDO = PropertyMapper.makePropertyDO(propertyDTO);
    return PropertyMapper.makePropertyDTO(propertyService.create(propertyDO));
  }


  @DeleteMapping("/{propertyId}")
  public void deleteDriver(@Valid @PathVariable long propertyId) throws EntityNotFoundException {
    propertyService.delete(propertyId);
  }
//
//  @PutMapping("/{propertyId}/car/{propertyId}")
//  public void selectProperty(
//      @Valid @PathVariable long propertyId, @Valid @PathVariable long propertyId)
//      throws EntityNotFoundException, CarAlreadyInUseException {
//    propertyService.selectProperty(propertyId, propertyId);
//  }

//
//  @PutMapping("/{propertyId}/deselectproperty")
//  public void unselectCar(
//      @Valid @PathVariable long propertyId)
//      throws ConstraintsViolationException, EntityNotFoundException {
//    propertyService.unselectProperty(propertyId);
//  }


  @RequestMapping(method = RequestMethod.GET, value = "/search")
  @ResponseBody
  public List<PropertyDO> search(@RequestParam(value = "q") String search,
      @RequestParam(value = "sorting") String sorting,
      @RequestParam(value = "page") Integer page,
      @RequestParam(value = "size") Integer size) {
    PropertyDOSpecificationBuilder builder = new PropertyDOSpecificationBuilder();
    Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
    Matcher matcher = pattern.matcher(search + ",");
    while (matcher.find()) {
      builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
    }
    Specification<PropertyDO> specification = builder.build();
    return propertyService.search(specification, createPageRequest(page, size, sorting)).getContent();
  }


  /**
   * Pagination and sorting
   *
   * @return Pageable object
   */
  private Pageable createPageRequest(int page, int size, String sorting) {
    String fields[] = {"street1", "street2", "street3"};
    Sort sort = new Sort(Sort.Direction.DESC, "property." + fields[0]);
    if (fields[1].equals(sorting)) {
      sort = new Sort(Sort.Direction.DESC, "property." + fields[1]);
    } else if (fields[2].equals(sorting)) {
      sort = new Sort(Sort.Direction.DESC, "property." + fields[2]);
    }
    return new PageRequest(page, size, sort);
  }


  @GetMapping
  public Iterable<PropertyDTO> findPropertys()
      throws ConstraintsViolationException, EntityNotFoundException {
    return PropertyMapper.makePropertyDTOList(StreamSupport.stream(propertyService.findAll().spliterator(), false)
            .collect(Collectors.toList()));
  }
}
