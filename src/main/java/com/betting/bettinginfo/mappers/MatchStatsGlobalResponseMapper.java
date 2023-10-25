package com.betting.bettinginfo.mappers;

import com.betting.bettinginfo.dto.match.Team;
import com.betting.bettinginfo.dto.match.stats.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class MatchStatsGlobalResponseMapper {
    GlobalMatchStatsResponse response = new GlobalMatchStatsResponse();
    List<StatisticLastMatches> statisticLastMatchesList = new ArrayList<>();

    public GlobalMatchStatsResponse map (Team team, List<MatchStats> matchStatsList ){
        response.setTeam(team);

        for(MatchStatEnum matchStatEnum : MatchStatEnum.values()){
            getStatForAllGamesByField(team, matchStatsList, matchStatEnum.getKeyJsonField(), matchStatEnum.getResponseJsonField());
        }

        response.setStats(statisticLastMatchesList);
        return response;
    }

    private void getStatForAllGamesByField(Team team, List<MatchStats> matchStatsList, String key, String response ){
        StatisticLastMatches statisticLastMatches = new StatisticLastMatches();
        statisticLastMatches.setType(response);

        List<String> statValues = getStatValuesByField(team, matchStatsList, key);

        statisticLastMatches.setValue(statValues);
        statisticLastMatchesList.add(statisticLastMatches);

    }

    /*private static List<String> getStatValuesByField(Team team, List<MatchStats> matchStatsList, String key) {
        Stream<MatchStatsResponse> matchStatsResponseStream = matchStatsList.stream()
                                                                 .flatMap(matchStats -> matchStats.getResponse().stream()
                                                                         .filter(matchStatsResponse -> matchStatsResponse.getTeam().getId() == team.getId()));
        Stream<Statistic> statisticStream = matchStatsResponseStream.flatMap(matchStatsResponse -> matchStatsResponse.getStatistics().stream());
        List<String> statValues = statisticStream.filter(statistic -> statistic.getType().equals(key))
                                             .map(statistic -> statistic.getValue())
                                             .collect(Collectors.toList());
        return statValues;
    }*/

    private static List<String> getStatValuesByField(Team team, List<MatchStats> matchStatsList, String key) {
        Stream<MatchStatsResponse> matchStatsResponseStream = matchStatsList.stream()
                .flatMap(matchStats -> matchStats.getResponse().stream()
                        .filter(matchStatsResponse -> matchStatsResponse.getTeam().getId() == team.getId()));
        Stream<Statistic> statisticStream = matchStatsResponseStream.flatMap(matchStatsResponse -> matchStatsResponse.getStatistics().stream());
        List<String> statValues = statisticStream.filter(statistic -> statistic.getType().equals(key))
                .map(statistic -> statistic.getValue())
                .collect(Collectors.toList());
        return statValues;
    }

}
