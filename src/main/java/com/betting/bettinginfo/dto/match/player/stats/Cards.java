
package com.betting.bettinginfo.dto.match.player.stats;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "yellow",
    "red"
})
public class Cards implements Serializable {

    @JsonProperty("yellow")
    public Integer yellow;
    @JsonProperty("red")
    public Integer red;

}
