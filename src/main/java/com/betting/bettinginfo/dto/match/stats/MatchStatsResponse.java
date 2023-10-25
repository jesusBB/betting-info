
package com.betting.bettinginfo.dto.match.stats;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class MatchStatsResponse {

    //@JsonProperty("team")
    public Team team;
    //@JsonProperty("statistics")
    public List<Statistic> statistics;

}
