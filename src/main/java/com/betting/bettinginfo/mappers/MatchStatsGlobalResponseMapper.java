package com.betting.bettinginfo.mappers;

import com.betting.bettinginfo.dto.match.stats.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class MatchStatsGlobalResponseMapper {


    public GlobalMatchStatsResponse map (Team team, List<MatchStats> matchStatsList ){
        //GlobalMatchStatsResponse response = new GlobalMatchStatsResponse();
        List<StatisticLastMatches> statisticLastMatchesList = new ArrayList<>();
        //response.setTeam(team);

        for(MatchStatEnum matchStatEnum : MatchStatEnum.values()){
            getStatForAllGamesByField(team, matchStatsList, matchStatEnum.getKeyJsonField(), matchStatEnum.getResponseJsonField(), statisticLastMatchesList);
        }

        //response.setStats(statisticLastMatchesList);
        return GlobalMatchStatsResponse.builder().team(team).stats(statisticLastMatchesList).build();
    }

    private void getStatForAllGamesByField(Team team, List<MatchStats> matchStatsList, String key, String response,  List<StatisticLastMatches> statisticLastMatchesList ){
        StatisticLastMatches statisticLastMatches = new StatisticLastMatches();
        statisticLastMatches.setType(response);

        List<StatsAndTeam> statValues = getStatValuesByField(team, matchStatsList, key);

        statisticLastMatches.setValues(statValues);
        statisticLastMatchesList.add(statisticLastMatches);

    }

    private static List<StatsAndTeam> getStatValuesByField(Team team, List<MatchStats> matchStatsList, String key) {
        Stream<MatchStatsResponse> matchStatsResponseStream = matchStatsList.stream()
                .flatMap(matchStats -> matchStats.getResponse().stream()
                .filter(matchStatsResponse -> matchStatsResponse.getTeam().getId() == team.getId()));

        Stream<Statistic> statisticStream = matchStatsResponseStream.flatMap(matchStatsResponse -> matchStatsResponse.getStatistics().stream());

        List<String> statValues = statisticStream.filter(statistic -> statistic.getType().equals(key))
                .map(statistic -> statistic.getValue())
                .collect(Collectors.toList());

        List<Team> rivals = MatchStats.getRivalsTeams(team, matchStatsList);

        //Having 2 collections, this will go by index through all the elements of both collections
        List<StatsAndTeam> statsAndTeamList = IntStream.range(0, Math.min(rivals.size(), statValues.size()))
                .mapToObj(i -> new StatsAndTeam(rivals.get(i).getName(), statValues.get(i)))
                .collect(Collectors.toList());

        return statsAndTeamList;
    }
}
