package com.betting.bettinginfo.services;

import com.betting.bettinginfo.clients.FootballAPIClient;
import com.betting.bettinginfo.dto.match.GlobalFixtureResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    @Value("${football-api.api-key}")
    String apiKey;

    FootballAPIClient footballAPIClient;

    public MatchService(FootballAPIClient footballAPIClient) {
        this.footballAPIClient = footballAPIClient;
    }

   // @Cacheable(value = "matchesByTeam", key = "#teamId")
    public GlobalFixtureResponse getMatchesByTeam(String teamId){
        return footballAPIClient.getLastMatchesByTeam( apiKey, teamId);
    }


}
