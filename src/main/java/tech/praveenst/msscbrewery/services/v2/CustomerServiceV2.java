package tech.praveenst.msscbrewery.services.v2;

import java.util.UUID;

import tech.praveenst.msscbrewery.web.model.v2.CustomerDtoV2;

public interface CustomerServiceV2 {
  public CustomerDtoV2 getById(UUID id);
  CustomerDtoV2 createCustomer(CustomerDtoV2 customerDto);
  CustomerDtoV2 updateCustomer(UUID customerID, CustomerDtoV2 customerDto);
  void deleteCustomer(UUID customerID);
}
