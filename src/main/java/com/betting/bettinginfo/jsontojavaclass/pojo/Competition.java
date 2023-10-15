
package com.betting.bettinginfo.jsontojavaclass.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "code",
    "type",
    "emblem"
})
public class Competition {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("code")
    public String code;
    @JsonProperty("type")
    public String type;
    @JsonProperty("emblem")
    public String emblem;

}
