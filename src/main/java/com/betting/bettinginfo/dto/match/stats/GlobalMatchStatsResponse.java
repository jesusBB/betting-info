package com.betting.bettinginfo.dto.match.stats;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GlobalMatchStatsResponse {
    private Team team;
    private List<StatisticLastMatches> stats;
}
