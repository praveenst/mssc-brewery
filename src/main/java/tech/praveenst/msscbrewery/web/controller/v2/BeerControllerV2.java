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

import tech.praveenst.msscbrewery.services.BeerService;
import tech.praveenst.msscbrewery.services.v2.BeerServiceV2;
import tech.praveenst.msscbrewery.web.model.v2.BeerDtoV2;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

  private final BeerServiceV2 beerService;

  public BeerControllerV2(BeerServiceV2 beerService) {
    this.beerService = beerService;
  }

  @GetMapping({"{beerId}"})
  // @PathVariable does not need to take the name of the id if name in GetMapping and input parameter matches
  // However, it is required if method parameter in this case UUID beerId is instead UUID beerIdentifier
  public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity createBeer(@RequestBody BeerDtoV2 beerDtoV2) {
    BeerDtoV2 newBeerObject = beerService.createNewBeer(beerDtoV2);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("location", "/api/v1/beer/" + newBeerObject.getId().toString());
    return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
  }

  @PutMapping({"{beerId}"})
  public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDtoV2) {
    return new ResponseEntity<>(beerService.updateBeer(beerId, beerDtoV2), HttpStatus.PARTIAL_CONTENT);

  }

  @DeleteMapping({"{beerId}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBeer(@PathVariable("beerId") UUID beerId) {
      beerService.deleteById(beerId);
  }



}
