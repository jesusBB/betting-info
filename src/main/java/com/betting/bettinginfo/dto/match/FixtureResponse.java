package com.betting.bettinginfo.dto.match;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class FixtureResponse {
    private Fixture fixture;
    private League league;
    private TeamsMatch teams;
    private Goals goals;
    private Score score;
}
