package com.betting.bettinginfo.dto.match;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"venue", "status", "referee", "timestamp", "periods", "timezone"})
public class Fixture implements Serializable {

    private long id;
    private String referee;
    private String timezone;
    private Date date;
    private String timestamp;
    private Periods periods;
    private Venue venue;
    private Status status;

}
