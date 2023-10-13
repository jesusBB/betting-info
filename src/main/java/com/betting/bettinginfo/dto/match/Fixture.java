package com.betting.bettinginfo.dto.match;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
public class Fixture {

    private long id;
    private String referee;
    private String timezone;
    private Date date;
    private String timestamp;
    private Periods periods;
    private Venue venue;
    private Status status;

}
