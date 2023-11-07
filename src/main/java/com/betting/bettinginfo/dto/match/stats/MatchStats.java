
package com.betting.bettinginfo.dto.match.stats;

import com.betting.bettinginfo.dto.match.player.stats.PlayerFixtureStatsResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class MatchStats implements Serializable {

   // @JsonProperty("get")
   // public String get;
   // @JsonProperty("parameters")
    //public Parameters parameters;
    //@JsonProperty("errors")
    //public List<Object> errors = new ArrayList<Object>();
    //@JsonProperty("results")
    //public Integer results;
    //@JsonProperty("paging")
    //public Paging paging;
    //@JsonProperty("response")
    public List<MatchStatsResponse> response;

    public static List<Team> getRivalsTeams(Team team, List<MatchStats> matchStatsList) {
        List<Team> rivals = matchStatsList.stream()
                .flatMap(matchStats -> matchStats.getResponse().stream()
                        .filter(matchStatsResponse -> matchStatsResponse.getTeam().getId() != team.getId()).map(matchStatsResponse -> matchStatsResponse.getTeam())).collect(Collectors.toList());
        return rivals;
    }


    public static List<com.betting.bettinginfo.dto.match.player.stats.Team> getRivalsTeams(Integer teamId, List<List<PlayerFixtureStatsResponse>> playersFixtureStats) {
       List<com.betting.bettinginfo.dto.match.player.stats.Team> rivals = playersFixtureStats.stream().flatMap(List::stream).filter(playerFixtureStatsResponse -> !playerFixtureStatsResponse.getTeam().getId().equals(teamId)).map(playerFixtureStatsResponse -> playerFixtureStatsResponse.getTeam()).collect(Collectors.toList());
       return rivals;
    }
}
