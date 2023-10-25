
package com.betting.bettinginfo.dto.match.stats;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fixture"
})
public class Parameters {

    @JsonProperty("fixture")
    public String fixture;

}
