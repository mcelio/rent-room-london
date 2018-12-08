package com.rent.controller;

import com.rent.controller.mapper.ContractMapper;
import com.rent.datatransferobject.ContractDTO;
import com.rent.domainobject.ContractDO;
import com.rent.exception.ConstraintsViolationException;
import com.rent.exception.EntityNotFoundException;
import com.rent.search.ContractDOSpecificationBuilder;
import com.rent.service.contract.ContractService;
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
 * All operations with a contract will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/contracts")
public class ContractController {

  private final ContractService contractService;


  @Autowired
  public ContractController(final ContractService contractService) {
    this.contractService = contractService;
  }


  @GetMapping("/{contractId}")
  public ContractDTO getDriver(@Valid @PathVariable long contractId) throws EntityNotFoundException {
    return ContractMapper.makeContractDTO(contractService.find(contractId));
  }


  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ContractDTO createContract(@Valid @RequestBody ContractDTO contractDTO)
      throws ConstraintsViolationException {
    ContractDO contractDO = ContractMapper.makeContractDO(contractDTO);
    return ContractMapper.makeContractDTO(contractService.create(contractDO));
  }


  @DeleteMapping("/{contractId}")
  public void deleteDriver(@Valid @PathVariable long contractId) throws EntityNotFoundException {
    contractService.delete(contractId);
  }
//
//  @PutMapping("/{contractId}/car/{contractId}")
//  public void selectContract(
//      @Valid @PathVariable long contractId, @Valid @PathVariable long contractId)
//      throws EntityNotFoundException, CarAlreadyInUseException {
//    contractService.selectContract(contractId, contractId);
//  }

//
//  @PutMapping("/{contractId}/deselectcontract")
//  public void unselectCar(
//      @Valid @PathVariable long contractId)
//      throws ConstraintsViolationException, EntityNotFoundException {
//    contractService.unselectContract(contractId);
//  }


  @RequestMapping(method = RequestMethod.GET, value = "/search")
  @ResponseBody
  public List<ContractDO> search(@RequestParam(value = "q") String search,
      @RequestParam(value = "sorting") String sorting,
      @RequestParam(value = "page") Integer page,
      @RequestParam(value = "size") Integer size) {
    ContractDOSpecificationBuilder builder = new ContractDOSpecificationBuilder();
    Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
    Matcher matcher = pattern.matcher(search + ",");
    while (matcher.find()) {
      builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
    }
    Specification<ContractDO> specification = builder.build();
    return contractService.search(specification, createPageRequest(page, size, sorting)).getContent();
  }


  /**
   * Pagination and sorting
   *
   * @return Pageable object
   */
  private Pageable createPageRequest(int page, int size, String sorting) {
    String fields[] = {"name", "contractType", "rating"};
    Sort sort = new Sort(Sort.Direction.DESC, "contract." + fields[0]);
    if (fields[1].equals(sorting)) {
      sort = new Sort(Sort.Direction.DESC, "contract." + fields[1]);
    } else if (fields[2].equals(sorting)) {
      sort = new Sort(Sort.Direction.DESC, "contract." + fields[2]);
    }
    return new PageRequest(page, size, sort);
  }


  @GetMapping
  public Iterable<ContractDTO> findContracts()
      throws ConstraintsViolationException, EntityNotFoundException {
    return ContractMapper.makeContractDTOList(StreamSupport.stream(contractService.findAll().spliterator(), false)
            .collect(Collectors.toList()));
  }
}
