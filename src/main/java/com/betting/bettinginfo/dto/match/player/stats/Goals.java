
package com.betting.bettinginfo.dto.match.player.stats;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "total",
    "conceded",
    "assists",
    "saves"
})
public class Goals implements Serializable {

    @JsonProperty("total")
    public Object total;
    @JsonProperty("conceded")
    public Integer conceded;
    @JsonProperty("assists")
    public Object assists;
    @JsonProperty("saves")
    public Object saves;

}
