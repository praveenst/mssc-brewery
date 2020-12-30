package tech.praveenst.msscbrewery.services;

import java.util.UUID;
import tech.praveenst.msscbrewery.web.model.CustomerDto;

/**
* author: praveen.thangavelu
* date: 2020-12-30T07:48:33Z
*/

public interface CustomerService {
  CustomerDto getById(UUID id);
  CustomerDto createCustomer(CustomerDto customerDto);
  CustomerDto updateCustomer(UUID customerID, CustomerDto customerDto);
  void deleteCustomer(UUID customerID);
}

