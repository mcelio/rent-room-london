package com.rent.controller;

import com.rent.controller.mapper.PaymentMapper;
import com.rent.datatransferobject.PaymentDTO;
import com.rent.domainobject.PaymentDO;
import com.rent.exception.ConstraintsViolationException;
import com.rent.exception.EntityNotFoundException;
import com.rent.search.PaymentDOSpecificationBuilder;
import com.rent.service.payment.PaymentService;
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
 * All operations with a payment will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/payments")
public class PaymentController {

  private final PaymentService paymentService;


  @Autowired
  public PaymentController(final PaymentService paymentService) {
    this.paymentService = paymentService;
  }


  @GetMapping("/{paymentId}")
  public PaymentDTO getDriver(@Valid @PathVariable long paymentId) throws EntityNotFoundException {
    return PaymentMapper.makePaymentDTO(paymentService.find(paymentId));
  }


  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PaymentDTO createPayment(@Valid @RequestBody PaymentDTO paymentDTO)
      throws ConstraintsViolationException {
    PaymentDO paymentDO = PaymentMapper.makePaymentDO(paymentDTO);
    return PaymentMapper.makePaymentDTO(paymentService.create(paymentDO));
  }


  @DeleteMapping("/{paymentId}")
  public void deleteDriver(@Valid @PathVariable long paymentId) throws EntityNotFoundException {
    paymentService.delete(paymentId);
  }
//
//  @PutMapping("/{paymentId}/car/{paymentId}")
//  public void selectPayment(
//      @Valid @PathVariable long paymentId, @Valid @PathVariable long paymentId)
//      throws EntityNotFoundException, CarAlreadyInUseException {
//    paymentService.selectPayment(paymentId, paymentId);
//  }

//
//  @PutMapping("/{paymentId}/deselectpayment")
//  public void unselectCar(
//      @Valid @PathVariable long paymentId)
//      throws ConstraintsViolationException, EntityNotFoundException {
//    paymentService.unselectPayment(paymentId);
//  }


  @RequestMapping(method = RequestMethod.GET, value = "/search")
  @ResponseBody
  public List<PaymentDO> search(@RequestParam(value = "q") String search,
      @RequestParam(value = "sorting") String sorting,
      @RequestParam(value = "page") Integer page,
      @RequestParam(value = "size") Integer size) {
    PaymentDOSpecificationBuilder builder = new PaymentDOSpecificationBuilder();
    Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
    Matcher matcher = pattern.matcher(search + ",");
    while (matcher.find()) {
      builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
    }
    Specification<PaymentDO> specification = builder.build();
    return paymentService.search(specification, createPageRequest(page, size, sorting)).getContent();
  }


  /**
   * Pagination and sorting
   *
   * @return Pageable object
   */
  private Pageable createPageRequest(int page, int size, String sorting) {
    String fields[] = {"name", "paymentType", "rating"};
    Sort sort = new Sort(Sort.Direction.DESC, "payment." + fields[0]);
    if (fields[1].equals(sorting)) {
      sort = new Sort(Sort.Direction.DESC, "payment." + fields[1]);
    } else if (fields[2].equals(sorting)) {
      sort = new Sort(Sort.Direction.DESC, "payment." + fields[2]);
    }
    return new PageRequest(page, size, sort);
  }


  @GetMapping
  public Iterable<PaymentDTO> findPayments()
      throws ConstraintsViolationException, EntityNotFoundException {
    return PaymentMapper.makePaymentDTOList(StreamSupport.stream(paymentService.findAll().spliterator(), false)
            .collect(Collectors.toList()));
  }
}
