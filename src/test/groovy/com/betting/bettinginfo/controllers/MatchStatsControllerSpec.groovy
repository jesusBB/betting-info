package com.betting.bettinginfo.controllers

import com.betting.bettinginfo.services.MatchService
import spock.lang.Specification

class MatchStatsControllerSpec extends Specification{

    MatchService matchService = Mock()


    def "Controller responds with match stats for the last games of the requested team"(){

        given: "a team id is recieved"
        def teamId = "1234"

        and: "match service responds with last matches for the team"
        matchService.getMatchesByTeam()

    }

}
