package com.betting.bettinginfo.dto.match;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = {"league", "teams", "goals", "score"})
public class FixtureResponse implements Serializable {
    private Fixture fixture;
    private League league;
    private TeamsMatch teams;
    private Goals goals;
    private Score score;
}
