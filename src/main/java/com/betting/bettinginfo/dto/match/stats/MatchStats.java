
package com.betting.bettinginfo.dto.match.stats;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class MatchStats {

   // @JsonProperty("get")
   // public String get;
   // @JsonProperty("parameters")
    public Parameters parameters;
    //@JsonProperty("errors")
    //public List<Object> errors = new ArrayList<Object>();
    //@JsonProperty("results")
    //public Integer results;
    //@JsonProperty("paging")
    //public Paging paging;
    //@JsonProperty("response")
    public List<MatchStatsResponse> response;

}
