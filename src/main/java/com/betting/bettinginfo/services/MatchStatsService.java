package com.betting.bettinginfo.services;

import com.betting.bettinginfo.clients.FootballAPIClient;
import com.betting.bettinginfo.dto.match.*;
import com.betting.bettinginfo.dto.match.stats.GlobalMatchStatsResponse;
import com.betting.bettinginfo.dto.match.stats.MatchStats;
import com.betting.bettinginfo.mappers.MatchStatsGlobalResponseMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
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

    @Cacheable(value = "matchStats" )
    public MatchStats getMatchStats(String fixtureId){
        System.out.println(("Getting match stats for the match " + fixtureId));
        return footballAPIClient.getMatchStats(apiKey, fixtureId);
    }
    @Cacheable(value = "matchStatsByField" )
    public GlobalMatchStatsResponse getMatchStatsByTeamId(String teamId){

       GlobalFixtureResponse matches = matchService.getMatchesByTeam(teamId);
       List<Long> fixturesId = matches.getResponse().stream().map(FixtureResponse::getFixture).map(Fixture::getId).collect(Collectors.toList());

       List<MatchStats> matchStatsList = new ArrayList<>();
       fixturesId.stream().forEach(fixtureId -> matchStatsList.add(getMatchStats(String.valueOf(fixtureId))));

       TeamsMatch teamsMatch = matches.getResponse().stream().map(fixtureResponse -> fixtureResponse.getTeams()).map(teamsMatch1 -> teamsMatch1).findFirst().get();
       Team team = TeamsMatch.getTeamFromMatch(teamId, teamsMatch);
       return matchStatsGlobalResponseMapper.map(team, matchStatsList);

    }



    @CacheEvict(value = {"matchStats", "matchStatsByField"}, allEntries = true)
    @Scheduled(fixedRateString = "20000")
    public void emptyCache() {
        System.out.println("Cleared cpm token cache");
    }

}
