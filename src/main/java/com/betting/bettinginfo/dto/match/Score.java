package com.betting.bettinginfo.dto.match;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Score {

    private Goals halftime;
    private Goals fulltime;
    private Goals extratime;
    private Goals penalty;

}
