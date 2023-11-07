
package com.betting.bettinginfo.dto.match.player.stats;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "won",
    "commited",
    "scored",
    "missed",
    "saved"
})
public class Penalty implements Serializable {

    @JsonProperty("won")
    public Object won;
    @JsonProperty("commited")
    public Object commited;
    @JsonProperty("scored")
    public Integer scored;
    @JsonProperty("missed")
    public Integer missed;
    @JsonProperty("saved")
    public Object saved;

}
