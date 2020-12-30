package tech.praveenst.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tech.praveenst.msscbrewery.services.CustomerService;
import tech.praveenst.msscbrewery.web.model.CustomerDto;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping({"{customerId}"})
  public ResponseEntity<CustomerDto> getById(@PathVariable("customerId") UUID custId) {
    return new ResponseEntity<>(customerService.getById(custId), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity createCustomer(@RequestBody CustomerDto customerDto) {
    CustomerDto customer = customerService.createCustomer(customerDto);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Location", "/api/v1/customer/" + customer.getId().toString() );
    return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
  }

  @PutMapping({"{customerId}"})
  public ResponseEntity updateCustomer(@PathVariable("customerId") UUID customerID,
      @RequestBody CustomerDto customerDto) {
    return new ResponseEntity<>(customerService.updateCustomer(customerID, customerDto), HttpStatus.PARTIAL_CONTENT);
  }

  @DeleteMapping({"{customerId}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCustomer(@PathVariable("customerId") UUID customerID) {
    customerService.deleteCustomer(customerID);
  }

}
