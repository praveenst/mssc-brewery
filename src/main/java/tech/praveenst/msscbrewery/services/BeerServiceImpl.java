package tech.praveenst.msscbrewery.services;

import java.util.UUID;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import tech.praveenst.msscbrewery.web.model.BeerDto;

/**
 * author: praveen.thangavelu
 * date: 2020-12-28T11:18:28Z
 */


@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
  @Override
  public BeerDto getBeerById(UUID beerId) {
    return BeerDto.builder().id(UUID.randomUUID())
        .beerName("Heineken Draft")
        .beerStyle("Lagar")
        .build();
  }

  @Override
  public BeerDto createNewBeer(BeerDto beerDto) {
    log.debug("Creating new beer...");
    return BeerDto.builder()
        .id(UUID.randomUUID())
        .build();
  }

  @Override
  public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
    beerDto.setId(beerId);
    System.out.println(beerDto.getId().toString());
    return beerDto;
  }

  @Override public void deleteById(UUID beerId) {
    log.debug("Deleting beer with Id: " + beerId);

  }
}
