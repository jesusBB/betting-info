package com.betting.bettinginfo.dto.match;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class League implements Serializable {

    private int id;
    private String name;
    private String country;
    private String logo;
    private String flag;
    private int season;
    private String round;

}
