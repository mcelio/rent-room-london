package com.rent.controller;

import com.rent.controller.mapper.BillMapper;
import com.rent.datatransferobject.BillDTO;
import com.rent.domainobject.BillDO;
import com.rent.exception.ConstraintsViolationException;
import com.rent.exception.EntityNotFoundException;
import com.rent.service.bill.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * All operations with a bill will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("bill")
public class BillController {

  private final BillService billService;


  @Autowired
  public BillController(final BillService billService) {
    this.billService = billService;
  }


  @GetMapping("/{billId}")
  public BillDTO getDriver(@Valid @PathVariable long billId) throws EntityNotFoundException {
    return BillMapper.makeBillDTO(billService.find(billId));
  }


  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BillDTO createBill(@Valid @RequestBody BillDTO billDTO)
      throws ConstraintsViolationException {
    BillDO billDO = BillMapper.makeBillDO(billDTO);
    return BillMapper.makeBillDTO(billService.create(billDO));
  }


  @DeleteMapping("/{billId}")
  public void deleteDriver(@Valid @PathVariable long billId) throws EntityNotFoundException {
    billService.delete(billId);
  }
//
//  @PutMapping("/{billId}/car/{billId}")
//  public void selectBill(
//      @Valid @PathVariable long billId, @Valid @PathVariable long billId)
//      throws EntityNotFoundException, CarAlreadyInUseException {
//    billService.selectBill(billId, billId);
//  }

//
//  @PutMapping("/{billId}/deselectbill")
//  public void unselectCar(
//      @Valid @PathVariable long billId)
//      throws ConstraintsViolationException, EntityNotFoundException {
//    billService.unselectBill(billId);
//  }

  /**
   * Pagination and sorting
   *
   * @return Pageable object
   */
  private Pageable createPageRequest(int page, int size, String sorting) {
    String fields[] = {"name", "billType", "rating"};
    Sort sort = new Sort(Sort.Direction.DESC, "bill." + fields[0]);
    if (fields[1].equals(sorting)) {
      sort = new Sort(Sort.Direction.DESC, "bill." + fields[1]);
    } else if (fields[2].equals(sorting)) {
      sort = new Sort(Sort.Direction.DESC, "bill." + fields[2]);
    }
    return new PageRequest(page, size, sort);
  }


  @GetMapping
  public Iterable<BillDTO> findBills()
      throws ConstraintsViolationException, EntityNotFoundException {
    return BillMapper.makeBillDTOList(StreamSupport.stream(billService.findAll().spliterator(), false)
            .collect(Collectors.toList()));
  }
}
