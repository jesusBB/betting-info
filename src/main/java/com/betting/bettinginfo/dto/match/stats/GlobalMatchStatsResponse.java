package com.betting.bettinginfo.dto.match.stats;

import com.betting.bettinginfo.dto.match.player.stats.PlayerFixtureStatsResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GlobalMatchStatsResponse implements Serializable {
    private Team team;
    private List<StatisticLastMatches> stats;
    private List<PlayerFixtureStatsResponse> playersStats;
}
