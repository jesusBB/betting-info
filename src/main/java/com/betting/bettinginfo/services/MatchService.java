package com.betting.bettinginfo.services;

import com.betting.bettinginfo.clients.FootballAPIClient;
import com.betting.bettinginfo.dto.match.GlobalFixtureResponse;
import org.springframework.stereotype.Service;

@Service
public class MatchService {



    FootballAPIClient footballAPIClient;

    public MatchService(FootballAPIClient footballAPIClient) {
        this.footballAPIClient = footballAPIClient;
    }

    public GlobalFixtureResponse getMatchesByTeam(String teamId){
        return footballAPIClient.getLastMatchesByTeam("2d2dae8c45fc506b0bb270e4defe1db7", teamId);
    }

}
