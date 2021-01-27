package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class Result {
    private String team1;
    private String team2;
    private String resultScore;
    private String event;
    private int matchRating;
}
