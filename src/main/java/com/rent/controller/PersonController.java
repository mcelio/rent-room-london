package com.rent.controller;

import com.rent.controller.mapper.PersonMapper;
import com.rent.datatransferobject.PersonDTO;
import com.rent.domainobject.PersonDO;
import com.rent.exception.ConstraintsViolationException;
import com.rent.exception.EntityNotFoundException;
import com.rent.search.PersonDOSpecificationBuilder;
import com.rent.service.person.PersonService;
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
 * All operations with a person will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/persons")
public class PersonController {

  private final PersonService personService;


  @Autowired
  public PersonController(final PersonService personService) {
    this.personService = personService;
  }


  @GetMapping("/{personId}")
  public PersonDTO getDriver(@Valid @PathVariable long personId) throws EntityNotFoundException {
    return PersonMapper.makePersonDTO(personService.find(personId));
  }


  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonDTO createPerson(@Valid @RequestBody PersonDTO personDTO)
      throws ConstraintsViolationException {
    PersonDO personDO = PersonMapper.makePersonDO(personDTO);
    return PersonMapper.makePersonDTO(personService.create(personDO));
  }


  @DeleteMapping("/{personId}")
  public void deleteDriver(@Valid @PathVariable long personId) throws EntityNotFoundException {
    personService.delete(personId);
  }
//
//  @PutMapping("/{personId}/car/{personId}")
//  public void selectPerson(
//      @Valid @PathVariable long personId, @Valid @PathVariable long personId)
//      throws EntityNotFoundException, CarAlreadyInUseException {
//    personService.selectPerson(personId, personId);
//  }

//
//  @PutMapping("/{personId}/deselectperson")
//  public void unselectCar(
//      @Valid @PathVariable long personId)
//      throws ConstraintsViolationException, EntityNotFoundException {
//    personService.unselectPerson(personId);
//  }


  @RequestMapping(method = RequestMethod.GET, value = "/search")
  @ResponseBody
  public List<PersonDO> search(@RequestParam(value = "q") String search,
      @RequestParam(value = "sorting") String sorting,
      @RequestParam(value = "page") Integer page,
      @RequestParam(value = "size") Integer size) {
    PersonDOSpecificationBuilder builder = new PersonDOSpecificationBuilder();
    Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
    Matcher matcher = pattern.matcher(search + ",");
    while (matcher.find()) {
      builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
    }
    Specification<PersonDO> specification = builder.build();
    return personService.search(specification, createPageRequest(page, size, sorting)).getContent();
  }


  /**
   * Pagination and sorting
   *
   * @return Pageable object
   */
  private Pageable createPageRequest(int page, int size, String sorting) {
    String fields[] = {"name", "personType", "rating"};
    Sort sort = new Sort(Sort.Direction.DESC, "person." + fields[0]);
    if (fields[1].equals(sorting)) {
      sort = new Sort(Sort.Direction.DESC, "person." + fields[1]);
    } else if (fields[2].equals(sorting)) {
      sort = new Sort(Sort.Direction.DESC, "person." + fields[2]);
    }
    return new PageRequest(page, size, sort);
  }


  @GetMapping
  public Iterable<PersonDTO> findPersons()
      throws ConstraintsViolationException, EntityNotFoundException {
    return PersonMapper.makePersonDTOList(StreamSupport.stream(personService.findAll().spliterator(), false)
            .collect(Collectors.toList()));
  }
}
