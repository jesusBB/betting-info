
package com.betting.bettinginfo.jsontojavaclass.pojo;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "filters",
    "resultSet",
    "competition",
    "matches"
})
public class Input {

    @JsonProperty("filters")
    public Filters filters;
    @JsonProperty("resultSet")
    public ResultSet resultSet;
    @JsonProperty("competition")
    public Competition competition;
    @JsonProperty("matches")
    public List<Match> matches = new ArrayList<Match>();

}
