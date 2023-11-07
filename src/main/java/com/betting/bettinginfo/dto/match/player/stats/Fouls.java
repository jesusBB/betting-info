
package com.betting.bettinginfo.dto.match.player.stats;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "drawn",
    "committed"
})
public class Fouls implements Serializable {

    @JsonProperty("drawn")
    public Object drawn;
    @JsonProperty("committed")
    public Object committed;

}
