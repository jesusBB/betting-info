package com.betting.bettinginfo.clients;

import com.betting.bettinginfo.dto.match.GlobalFixtureResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "football-api-client", url = "${football-api.base-url}" )
public interface FootballAPIClient {
   String API_KEY_HEADER_NAME = "x-rapidapi-key";

   @GetMapping(value = "/fixtures?last=10&team={teamId}")
   GlobalFixtureResponse getLastMatchesByTeam(@RequestHeader(API_KEY_HEADER_NAME) String apiKey,@PathVariable String teamId);

}
