package com.betting.bettinginfo.dto.match;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class Status implements Serializable {

    private String longStatus;
    private String shortStatus;
    private int elapsed;

}
