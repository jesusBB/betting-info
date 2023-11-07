
package com.betting.bettinginfo.dto.match.player.stats;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attempts",
    "success",
    "past"
})
public class Dribbles implements Serializable {

    @JsonProperty("attempts")
    public Object attempts;
    @JsonProperty("success")
    public Object success;
    @JsonProperty("past")
    public Object past;

}
