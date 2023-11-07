
package com.betting.bettinginfo.dto.match.player.stats;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "games",
    "offsides",
    "shots",
    "goals",
    "passes",
    "tackles",
    "duels",
    "dribbles",
    "fouls",
    "cards",
    "penalty"
})
public class Statistic implements Serializable {

    @JsonProperty("games")
    public Games games;
    @JsonProperty("offsides")
    public Object offsides;
    @JsonProperty("shots")
    public Shots shots;
    @JsonProperty("goals")
    public Goals goals;
    @JsonProperty("passes")
    public Passes passes;
    @JsonProperty("tackles")
    public Tackles tackles;
    @JsonProperty("duels")
    public Duels duels;
    @JsonProperty("dribbles")
    public Dribbles dribbles;
    @JsonProperty("fouls")
    public Fouls fouls;
    @JsonProperty("cards")
    public Cards cards;
    @JsonProperty("penalty")
    public Penalty penalty;

}
