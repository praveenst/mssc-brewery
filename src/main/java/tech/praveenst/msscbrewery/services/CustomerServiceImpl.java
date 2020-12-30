package tech.praveenst.msscbrewery.services;

import java.util.UUID;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tech.praveenst.msscbrewery.web.model.CustomerDto;


/**
 * author: praveen.thangavelu
 * date: 2020-12-28T11:10:21Z
 */

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
  @Override
  public CustomerDto getById(UUID id) {
    return CustomerDto.builder()
        .id(UUID.randomUUID())
        .name("Praveen Thangavelu")
        .build();
  }

  @Override
  public CustomerDto createCustomer(CustomerDto customerDto) {
    log.debug("Creating new customer");
    return CustomerDto.builder()
        .id(UUID.randomUUID())
        .name(customerDto.getName())
        .build();
  }

  @Override
  public CustomerDto updateCustomer(UUID customerID, CustomerDto customerDto) {
    log.debug("Updating Customer: " + customerDto.getId());
    customerDto.setId(customerID);
    return customerDto;
  }

  @Override
  public void deleteCustomer(UUID customerID) {
    log.debug("Deleting Customer: " + customerID);
  }
}
