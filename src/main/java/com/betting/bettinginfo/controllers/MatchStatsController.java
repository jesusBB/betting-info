package com.betting.bettinginfo.controllers;

import com.betting.bettinginfo.dto.match.GlobalFixtureResponse;
import com.betting.bettinginfo.dto.match.stats.GlobalMatchStatsResponse;
import com.betting.bettinginfo.dto.match.stats.MatchStats;
import com.betting.bettinginfo.services.MatchService;
import com.betting.bettinginfo.services.MatchStatsService;
import com.betting.bettinginfo.services.PlayerMatchStatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class MatchStatsController {

    private final MatchService matchService;
    private final MatchStatsService matchStatsService;

    private final PlayerMatchStatsService playerMatchStatsService;

    public MatchStatsController(MatchService matchService, MatchStatsService matchStatsService, PlayerMatchStatsService playerMatchStatsService) {
        this.matchService = matchService;
        this.matchStatsService = matchStatsService;
        this.playerMatchStatsService = playerMatchStatsService;
    }

    @GetMapping(value = "/team/{teamId}")
    public ResponseEntity<GlobalFixtureResponse> getLastMatches(@PathVariable String teamId){
        GlobalFixtureResponse globalFixtureResponse = matchService.getMatchesByTeam(teamId);
        //MatchStats matchStats = matchStatsService.getMatchStats(teamId);
        return ResponseEntity.ok(globalFixtureResponse);
    }
    @GetMapping(value = "/fixture/{fixtureId}")
    public ResponseEntity<MatchStats> getMatchStats(@PathVariable String fixtureId){
        //GlobalFixtureResponse globalFixtureResponse = matchService.getMatchesByTeam(teamId);
        MatchStats matchStats = matchStatsService.getMatchStats(fixtureId);
        return ResponseEntity.ok(matchStats);
    }

    @GetMapping(value = "/team/{teamId}/match/stats")

    public ResponseEntity<GlobalMatchStatsResponse> getMatchStatsByTeamId(@PathVariable String teamId){
        GlobalMatchStatsResponse matchStatsList = matchStatsService.getMatchStatsByTeamId(teamId);
        return ResponseEntity.ok(matchStatsList);
    }

    @GetMapping(value = "/team/{teamId}/match/stats/playerName/{playerName}")
    public ResponseEntity<GlobalMatchStatsResponse> getMatchStatsByTeamId(@PathVariable String teamId, @PathVariable String playerName){
        GlobalMatchStatsResponse matchStatsList = matchStatsService.getMatchStatsByTeamId(teamId);
        playerMatchStatsService.getPlayerStatsByFixtureIdAndPlayerName(teamId, playerName, matchStatsList);

        return ResponseEntity.ok(matchStatsList);
    }

}
