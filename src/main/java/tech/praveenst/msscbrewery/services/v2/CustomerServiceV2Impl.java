package tech.praveenst.msscbrewery.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tech.praveenst.msscbrewery.web.model.CustomerDto;
import tech.praveenst.msscbrewery.web.model.v2.CustomerDtoV2;

/**
 * author: praveen.thangavelu
 * date: 2020-12-28T11:10:21Z
 */

@Service
@Slf4j
public class CustomerServiceV2Impl implements CustomerServiceV2 {
  @Override
  public CustomerDtoV2 getById(UUID id) {
    return CustomerDtoV2.builder()
        .id(UUID.randomUUID())
        .name("Praveen Thangavelu")
        .build();
  }

  @Override
  public CustomerDtoV2 createCustomer(CustomerDtoV2 customerDto) {
    log.debug("Creating new customer");
    return CustomerDtoV2.builder()
        .id(UUID.randomUUID())
        .name(customerDto.getName())
        .build();
  }

  @Override public CustomerDtoV2 updateCustomer(UUID customerID, CustomerDtoV2 customerDto) {
    log.debug("Updating Customer: " + customerDto.getId());
    customerDto.setId(customerID);
    return customerDto;
  }

  @Override public void deleteCustomer(UUID customerID) {
    log.debug("Deleting Customer: " + customerID);
  }
}
