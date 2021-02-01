package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class TopTeam {
    private String position;
    private String name;
    private String points;
    private List<String> players;
    private List<String> urls;

    private String photoUrl;

    @Override
    public String toString() {
        return "TopTeam{" +
                "position='" + position + '\'' +
                ", name='" + name + '\'' +
                ", points='" + points + '\'' +
                ", players=" + players +
                ", urls=" + urls +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }

}
