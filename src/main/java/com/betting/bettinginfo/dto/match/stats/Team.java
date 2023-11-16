
package com.betting.bettinginfo.dto.match.stats;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
public class Team implements Serializable {

 //   @JsonProperty("id")
    public int id;
  //  @JsonProperty("name")
    public String name;
  //  @JsonProperty("logo")
    public String logo;

}
