
package com.betting.bettinginfo.dto.match.player.stats;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "total",
    "blocks",
    "interceptions"
})
public class Tackles implements Serializable {

    @JsonProperty("total")
    public Object total;
    @JsonProperty("blocks")
    public Object blocks;
    @JsonProperty("interceptions")
    public Object interceptions;

}
