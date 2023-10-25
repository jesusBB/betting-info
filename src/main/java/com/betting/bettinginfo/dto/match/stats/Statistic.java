
package com.betting.bettinginfo.dto.match.stats;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Statistic {

    //@JsonProperty("type")
    public String type;
    //@JsonProperty("value")
    public String value;

}
