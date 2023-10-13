package com.betting.bettinginfo.controllers;

import com.betting.bettinginfo.dto.match.GlobalFixtureResponse;
import com.betting.bettinginfo.services.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class MatchStatsController {

    private final MatchService matchService;

    public MatchStatsController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping(value = "/team/{teamId}")
    public ResponseEntity<GlobalFixtureResponse> getMatchStats(@PathVariable String teamId){
        System.out.printf("teamId is : %s", teamId);
        GlobalFixtureResponse globalFixtureResponse = matchService.getMatchesByTeam(teamId);
        return ResponseEntity.ok(globalFixtureResponse);
    }

}
