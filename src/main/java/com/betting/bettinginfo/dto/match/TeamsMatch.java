package com.betting.bettinginfo.dto.match;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TeamsMatch {
    private Team home;
    private Team away;

    public static Team getTeamFromMatch(String teamId, TeamsMatch teamsMatch) {
        return teamId.equals(String.valueOf(teamsMatch.getAway().getId())) ? teamsMatch.getAway() : teamsMatch.getHome();
    }
}
