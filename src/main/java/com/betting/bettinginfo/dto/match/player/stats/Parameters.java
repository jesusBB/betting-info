
package com.betting.bettinginfo.dto.match.player.stats;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fixture"
})
public class Parameters implements Serializable {

    @JsonProperty("fixture")
    public String fixture;

}
