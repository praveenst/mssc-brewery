package tech.praveenst.msscbrewery.web.model.v2;

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
public class BeerDtoV2 {

  private UUID id;
  private String beerName;
  private BeerStyle beerStyle;
  private Long upc;

}
