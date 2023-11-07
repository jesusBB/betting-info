
package com.betting.bettinginfo.dto.match.player.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
public class PlayerStats implements Serializable {

    @JsonProperty("player")
    public Player player;
    @JsonProperty("statistics")
    public List<Statistic> statistics = new ArrayList<>();

}
