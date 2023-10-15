
package com.betting.bettinginfo.jsontojavaclass.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "count",
    "first",
    "last",
    "played"
})
public class ResultSet {

    @JsonProperty("count")
    public Integer count;
    @JsonProperty("first")
    public String first;
    @JsonProperty("last")
    public String last;
    @JsonProperty("played")
    public Integer played;

}
