
package com.betting.bettinginfo.jsontojavaclass.pojo;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "area",
    "competition",
    "season",
    "id",
    "utcDate",
    "status",
    "matchday",
    "stage",
    "group",
    "lastUpdated",
    "homeTeam",
    "awayTeam",
    "score",
    "odds",
    "referees"
})
public class Match {

    @JsonProperty("area")
    public Area area;
    @JsonProperty("competition")
    public Competition__1 competition;
    @JsonProperty("season")
    public Season season;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("utcDate")
    public String utcDate;
    @JsonProperty("status")
    public String status;
    @JsonProperty("matchday")
    public Object matchday;
    @JsonProperty("stage")
    public String stage;
    @JsonProperty("group")
    public Object group;
    @JsonProperty("lastUpdated")
    public String lastUpdated;
    @JsonProperty("homeTeam")
    public HomeTeam homeTeam;
    @JsonProperty("awayTeam")
    public AwayTeam awayTeam;
    @JsonProperty("score")
    public Score score;
    @JsonProperty("odds")
    public Odds odds;
    @JsonProperty("referees")
    public List<Referee> referees = new ArrayList<Referee>();

}
