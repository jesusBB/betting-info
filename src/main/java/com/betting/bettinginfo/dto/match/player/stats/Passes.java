
package com.betting.bettinginfo.dto.match.player.stats;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "total",
    "key",
    "accuracy"
})
public class Passes implements Serializable {

    @JsonProperty("total")
    public Object total;
    @JsonProperty("key")
    public Object key;
    @JsonProperty("accuracy")
    public Object accuracy;

}
