package com.betting.bettinginfo.clients;

import com.betting.bettinginfo.dto.match.GlobalFixtureResponse;
import com.betting.bettinginfo.dto.match.player.stats.PlayersFixtureStats;
import com.betting.bettinginfo.dto.match.stats.MatchStats;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "football-api-client", url = "${football-api.base-url}" )
//@FeignClient(value = "football-api-client", url = "http://localhost:8089" )
public interface FootballAPIClient {
   String API_KEY_HEADER_NAME = "x-rapidapi-key";

   @GetMapping(value = "/fixtures?last=6&team={teamId}")
   GlobalFixtureResponse getLastMatchesByTeam(@RequestHeader(API_KEY_HEADER_NAME) String apiKey,@PathVariable String teamId);

   @GetMapping(value = "/fixtures/statistics?fixture={fixtureId}")
   MatchStats getMatchStats(@RequestHeader(API_KEY_HEADER_NAME) String apiKey, @PathVariable String fixtureId);

   @GetMapping(value = "/fixtures/players?fixture={fixtureId}")
   PlayersFixtureStats getPlayerMatchStats(@RequestHeader(API_KEY_HEADER_NAME) String apiKey, @PathVariable String fixtureId);


}
