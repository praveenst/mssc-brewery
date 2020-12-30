package tech.praveenst.msscbrewery.web.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Enable Lombak Annotations


/**
 * Created by Praveen Thangavelu on
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

  private UUID id;
  private String beerName;
  private String beerStyle;
  private Long upc;

}
