package com.betting.bettinginfo.dto.match;

import com.betting.bettinginfo.dto.match.stats.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class TeamsMatch implements Serializable {
    private Team home;
    private Team away;

    public static Team getRivalTeamFromMatch(String teamId, TeamsMatch teamsMatch) {
        return teamId.equals(String.valueOf(teamsMatch.getAway().getId())) ? teamsMatch.getAway() : teamsMatch.getHome();
    }
}
