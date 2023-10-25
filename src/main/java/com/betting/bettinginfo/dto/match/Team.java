package com.betting.bettinginfo.dto.match;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"logo", "winner"})
public class Team {

    private int id;
    private String name;
    private String logo;
    private boolean winner;

}
