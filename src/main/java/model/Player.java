package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class Player {
    private String nickName;
    private String realName;
    private String age;
    private String currentTeam;

    private float rating2_0;
    private float killsPerRound;
    private String headshots;
    private int mapsPlayed;
    private float deathPerRound;

    private String photoUrl;
}
