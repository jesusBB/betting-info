
package com.betting.bettinginfo.dto.match.player.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PlayerFixtureStatsResponse implements Serializable {

    @JsonProperty("team")
    public Team team;
    @JsonProperty("players")
    public List<PlayerStats> players = new ArrayList<>();

}
