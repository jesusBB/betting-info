package com.betting.bettinginfo.services;

import com.betting.bettinginfo.clients.FootballAPIClient;
import com.betting.bettinginfo.dto.match.Fixture;
import com.betting.bettinginfo.dto.match.FixtureResponse;
import com.betting.bettinginfo.dto.match.GlobalFixtureResponse;
import com.betting.bettinginfo.dto.match.TeamsMatch;
import com.betting.bettinginfo.dto.match.stats.GlobalMatchStatsResponse;
import com.betting.bettinginfo.dto.match.stats.MatchStats;
import com.betting.bettinginfo.dto.match.stats.Team;
import com.betting.bettinginfo.mappers.MatchStatsGlobalResponseMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchStatsService {

    @Value("${football-api.api-key}")
    String apiKey;
    FootballAPIClient footballAPIClient;
    MatchService matchService;

    MatchStatsGlobalResponseMapper matchStatsGlobalResponseMapper;


    public MatchStatsService(FootballAPIClient footballAPIClient, MatchService matchService, MatchStatsGlobalResponseMapper matchStatsGlobalResponseMapper) {
        this.footballAPIClient = footballAPIClient;
        this.matchService = matchService;
        this.matchStatsGlobalResponseMapper = matchStatsGlobalResponseMapper;
    }

    //@Cacheable(value = "partidosStats", key = "#fixtureId")
    public MatchStats getMatchStats(String fixtureId){
        System.out.println(("Getting match stats for the match " + fixtureId));
        return footballAPIClient.getMatchStats(apiKey, fixtureId);
    }
    @Cacheable(value = "matchStatsByTeamId"/*, key = "#teamId"*/)
    public GlobalMatchStatsResponse getMatchStatsByTeamId(String teamId){

       GlobalFixtureResponse matches = matchService.getMatchesByTeam(teamId);
       List<Long> fixturesId = getFixturesIdFromMatches(matches);

       List<MatchStats> matchStatsList = new ArrayList<>();
       fixturesId.stream().forEach(fixtureId -> matchStatsList.add(getMatchStats(String.valueOf(fixtureId))));

       TeamsMatch teamsMatch = matches.getResponse().stream().map(fixtureResponse -> fixtureResponse.getTeams()).findFirst().get();
       Team team = TeamsMatch.getRivalTeamFromMatch(teamId, teamsMatch);
       return matchStatsGlobalResponseMapper.map(team, matchStatsList);

    }

    public List<Long> getFixturesIdFromMatches(GlobalFixtureResponse matches) {
        return matches.getResponse().stream().map(FixtureResponse::getFixture).map(Fixture::getId).collect(Collectors.toList());
    }


   // @CacheEvict(value = {"partidosStats", "matchStatsByField"}, allEntries = true)
   // @Scheduled(fixedRateString = "20000")
    public void emptyCache() {
        System.out.println("Cleared cpm token cache");
    }

}
