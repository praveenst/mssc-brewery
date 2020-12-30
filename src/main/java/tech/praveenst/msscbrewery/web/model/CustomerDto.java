package tech.praveenst.msscbrewery.web.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Praveen Thangavelu
 * 2020-12-28T10:51:59.528Z
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

  private UUID id;
  private String name;


}
