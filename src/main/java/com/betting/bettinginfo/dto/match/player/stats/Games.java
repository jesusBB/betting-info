
package com.betting.bettinginfo.dto.match.player.stats;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "minutes",
    "number",
    "position",
    "rating",
    "captain",
    "substitute"
})
public class Games implements Serializable {

    @JsonProperty("minutes")
    public Object minutes;
    @JsonProperty("number")
    public Integer number;
    @JsonProperty("position")
    public String position;
    @JsonProperty("rating")
    public Object rating;
    @JsonProperty("captain")
    public Boolean captain;
    @JsonProperty("substitute")
    public Boolean substitute;

}
