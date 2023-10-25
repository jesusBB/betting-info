package com.betting.bettinginfo.mappers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MatchStatEnum {
    CORNER_KICK("Corner Kicks","corner_kicks"),
    SHOTS_ON_TARGET("Shots on Goal","shots_on_target"),
    SHOTS_OFF_TARGET("Shots off Goal","shots_off_target"),
    FOULS("Fouls","fouls"),
    GOALKEEPER_SAVES("Goalkeeper Saves", "goalkeeper_saves"),
    OFFSIDES("Offsides", "offsides"),
    YELLOW_CARDS("Yellow Cards", "yellow_cards"),
    RED_CARDS("Red Cards", "red_cards");

    private String keyJsonField;
    private String responseJsonField;

}
