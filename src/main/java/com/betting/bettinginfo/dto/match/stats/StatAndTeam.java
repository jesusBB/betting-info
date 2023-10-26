package com.betting.bettinginfo.dto.match.stats;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class StatAndTeam {
    private String value;
    private Team otherTeam;
}
