package tech.praveenst.msscbrewery.services;

import java.util.UUID;
import tech.praveenst.msscbrewery.web.model.BeerDto;

/**
 * Created by Praveen Thangavelu
 */

public interface BeerService {
   BeerDto getBeerById(UUID beerId);
   BeerDto createNewBeer(BeerDto beerDto);
   BeerDto updateBeer(UUID beerId, BeerDto beerDto);
   void deleteById(UUID beerId);
}
