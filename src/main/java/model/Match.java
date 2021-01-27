package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class Match {
    private String time;
    private String team1;
    private String team2;
    private String tournament;
    private String matchMeta;
    private int matchRating;
}
