package tech.praveenst.msscbrewery.services.v2;

import java.util.UUID;

import tech.praveenst.msscbrewery.web.model.v2.BeerDtoV2;

/**
 * Created by Praveen Thangavelu
 */

public interface BeerServiceV2 {
   BeerDtoV2 getBeerById(UUID beerId);
   BeerDtoV2 createNewBeer(BeerDtoV2 beerDto);
   BeerDtoV2 updateBeer(UUID beerId, BeerDtoV2 beerDto);
   void deleteById(UUID beerId);
}
