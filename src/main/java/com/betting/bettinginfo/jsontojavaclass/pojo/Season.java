
package com.betting.bettinginfo.jsontojavaclass.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "startDate",
    "endDate",
    "currentMatchday",
    "winner"
})
public class Season {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("startDate")
    public String startDate;
    @JsonProperty("endDate")
    public String endDate;
    @JsonProperty("currentMatchday")
    public Integer currentMatchday;
    @JsonProperty("winner")
    public Object winner;

}
