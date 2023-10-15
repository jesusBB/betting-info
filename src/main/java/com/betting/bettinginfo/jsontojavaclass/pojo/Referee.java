
package com.betting.bettinginfo.jsontojavaclass.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "type",
    "nationality"
})
public class Referee {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("type")
    public String type;
    @JsonProperty("nationality")
    public String nationality;

}
