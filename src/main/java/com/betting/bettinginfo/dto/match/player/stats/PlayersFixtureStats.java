
package com.betting.bettinginfo.dto.match.player.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PlayersFixtureStats {

    @JsonProperty("get")
    public String get;
    @JsonProperty("parameters")
    public Parameters parameters;
   // @JsonProperty("errors")
   // public List<Object> errors = new ArrayList<Object>();
    @JsonProperty("results")
    public Integer results;
    @JsonProperty("paging")
    public Paging paging;
    @JsonProperty("response")
    public List<PlayerFixtureStatsResponse> response = new ArrayList<>();

}
