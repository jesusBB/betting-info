
package com.betting.bettinginfo.dto.match.stats;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Team implements Serializable {

 //   @JsonProperty("id")
    public int id;
  //  @JsonProperty("name")
    public String name;
  //  @JsonProperty("logo")
    public String logo;

}
