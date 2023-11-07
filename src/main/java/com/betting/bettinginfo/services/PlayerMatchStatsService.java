package com.betting.bettinginfo.services;

import com.betting.bettinginfo.clients.FootballAPIClient;
import com.betting.bettinginfo.dto.match.GlobalFixtureResponse;
import com.betting.bettinginfo.dto.match.player.stats.PlayerFixtureStatsResponse;
import com.betting.bettinginfo.dto.match.player.stats.PlayerStats;
import com.betting.bettinginfo.dto.match.stats.GlobalMatchStatsResponse;
import com.betting.bettinginfo.dto.match.stats.MatchStats;
import com.betting.bettinginfo.mappers.MatchStatsGlobalResponseMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PlayerMatchStatsService {

    @Value("${football-api.api-key}")
    String apiKey;
    FootballAPIClient footballAPIClient;
    MatchService matchService;

    MatchStatsService matchStatsService ;

    MatchStatsGlobalResponseMapper matchStatsGlobalResponseMapper;


    public PlayerMatchStatsService(FootballAPIClient footballAPIClient, MatchService matchService, MatchStatsService matchStatsService, MatchStatsGlobalResponseMapper matchStatsGlobalResponseMapper) {
        this.footballAPIClient = footballAPIClient;
        this.matchService = matchService;
        this.matchStatsService = matchStatsService;
        this.matchStatsGlobalResponseMapper = matchStatsGlobalResponseMapper;
    }

   // @Cacheable(value = "playerStats", key = "{#playerName, #teamId}")
    public GlobalMatchStatsResponse getPlayerStatsByFixtureIdAndPlayerName(String teamId, String playerName, GlobalMatchStatsResponse matchStatsList){
        GlobalFixtureResponse matches = matchService.getMatchesByTeam(teamId);
        List<Long> fixturesId = matchStatsService.getFixturesIdFromMatches(matches);

        List<List<PlayerFixtureStatsResponse>> playersFixtureStats = new ArrayList<>();
        fixturesId.stream().forEach(fixtureId -> playersFixtureStats.add(footballAPIClient.getPlayerMatchStats(apiKey, String.valueOf(fixtureId)).getResponse()));

        //Get Rivals to set them in the response
        List<com.betting.bettinginfo.dto.match.player.stats.Team> rivals = MatchStats.getRivalsTeams(Integer.valueOf(teamId), playersFixtureStats);

        List<PlayerFixtureStatsResponse> filteredLists = getFilteredPlayerStats(playerName, playersFixtureStats);

        IntStream.range(0, Math.min(rivals.size(), filteredLists.size()))
                .forEach(i -> filteredLists.get(i).setTeam(rivals.get(i)));

        matchStatsList.setPlayersStats(filteredLists);
        return matchStatsList;
    }

    private static List<PlayerFixtureStatsResponse> getFilteredPlayerStats(String playerName, List<List<PlayerFixtureStatsResponse>> playersFixtureStats) {
        return playersFixtureStats.stream()
                .flatMap(List::stream)
                .map(response -> {
                    return filterPlayerByName(playerName, response);
                }).filter(playerFixtureStatsResponse -> !playerFixtureStatsResponse.getPlayers().isEmpty())
                .collect(Collectors.toList());
    }

    private static PlayerFixtureStatsResponse filterPlayerByName(String playerName, PlayerFixtureStatsResponse response) {
        // Filter PlayerStats based on playerName
        List<PlayerStats> filteredPlayerStats = response.getPlayers().stream()
                .filter(playerStats -> playerStats.getPlayer().getName().contains(playerName))
                .collect(Collectors.toList());

        // Create a new PlayerFixtureStatsResponse with filtered PlayerStats
        PlayerFixtureStatsResponse filteredResponse = new PlayerFixtureStatsResponse();
        //filteredResponse.setTeam( response.team);
        filteredResponse.setPlayers(filteredPlayerStats);

        return filteredResponse;
    }


    //@CacheEvict(value = {"matchStats", "matchStatsByField"}, allEntries = true)
    //@Scheduled(fixedRateString = "20000")
    public void emptyCache() {
        System.out.println("Cleared cpm token cache");
    }

}
