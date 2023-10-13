package com.betting.bettinginfo.dto.match;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Status {

    private String longStatus;
    private String shortStatus;
    private int elapsed;

}
