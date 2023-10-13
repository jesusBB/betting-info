package com.betting.bettinginfo.dto.match;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class League {

    private int id;
    private String name;
    private String country;
    private String logo;
    private String flag;
    private int season;
    private String round;

}
