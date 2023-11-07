package com.betting.bettinginfo.dto.match.stats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatsAndTeam implements Serializable {
    private String rivalTeamName;
    private String value;
}
