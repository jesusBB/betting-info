
package com.betting.bettinginfo.jsontojavaclass.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "shortName",
    "tla",
    "crest"
})
public class AwayTeam {

    @JsonProperty("id")
    public Object id;
    @JsonProperty("name")
    public Object name;
    @JsonProperty("shortName")
    public Object shortName;
    @JsonProperty("tla")
    public Object tla;
    @JsonProperty("crest")
    public Object crest;

}
