package tech.praveenst.msscbrewery.web.controller.v2;

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

import tech.praveenst.msscbrewery.services.v2.CustomerServiceV2;
import tech.praveenst.msscbrewery.web.model.v2.CustomerDtoV2;

@RequestMapping("/api/v2/customer")
@RestController
public class CustomerControllerV2 {

  private final CustomerServiceV2 customerService;

  public CustomerControllerV2(CustomerServiceV2 customerService) {
    this.customerService = customerService;
  }

  @GetMapping({"{customerId}"})
  public ResponseEntity<CustomerDtoV2> getById(@PathVariable("customerId") UUID custId) {
    return new ResponseEntity<>(customerService.getById(custId), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity createCustomer(@RequestBody CustomerDtoV2 customerDtoV2) {
    CustomerDtoV2 customer = customerService.createCustomer(customerDtoV2);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Location", "/api/v1/customer/" + customer.getId().toString() );
    return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
  }

  @PutMapping({"{customerId}"})
  public ResponseEntity updateCustomer(@PathVariable("customerId") UUID customerID,
      @RequestBody CustomerDtoV2 customerDtoV2) {
    return new ResponseEntity<>(customerService.updateCustomer(customerID, customerDtoV2), HttpStatus.PARTIAL_CONTENT);
  }

  @DeleteMapping({"{customerId}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCustomer(@PathVariable("customerId") UUID customerID) {
    customerService.deleteCustomer(customerID);
  }

}
