package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class TopTeam {
    private String position;
    private String name;
    private String points;
    private List<String> players;
}
