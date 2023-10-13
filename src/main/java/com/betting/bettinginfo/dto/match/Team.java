package com.betting.bettinginfo.dto.match;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Team {

    private int id;
    private String name;
    private String logo;
    private boolean winner;

}
