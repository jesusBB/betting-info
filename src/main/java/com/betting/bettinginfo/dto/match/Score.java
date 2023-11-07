package com.betting.bettinginfo.dto.match;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class Score implements Serializable {

    private Goals halftime;
    private Goals fulltime;
    private Goals extratime;
    private Goals penalty;

}
