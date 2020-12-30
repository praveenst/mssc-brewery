package tech.praveenst.msscbrewery.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tech.praveenst.msscbrewery.web.model.BeerDto;
import tech.praveenst.msscbrewery.web.model.v2.BeerDtoV2;
import tech.praveenst.msscbrewery.web.model.v2.BeerStyle;

/**
 * author: praveen.thangavelu
 * date: 2020-12-28T11:18:28Z
 */


@Service
@Slf4j
public class BeerServiceV2Impl implements BeerServiceV2 {
  @Override
  public BeerDtoV2 getBeerById(UUID beerId) {
    return BeerDtoV2.builder().id(UUID.randomUUID())
        .beerName("Heineken Draft")
        .beerStyle(BeerStyle.ALE)
        .build();
  }

  @Override
  public BeerDtoV2 createNewBeer(BeerDtoV2 beerDto) {
    log.debug("Creating new beer...");
    return BeerDtoV2.builder()
        .id(UUID.randomUUID())
        .build();
  }

  @Override
  public BeerDtoV2 updateBeer(UUID beerId, BeerDtoV2 beerDto) {
    beerDto.setId(beerId);
    System.out.println(beerDto.getId().toString());
    return beerDto;
  }

  @Override public void deleteById(UUID beerId) {
    log.debug("Deleting beer with Id: " + beerId);

  }
}
