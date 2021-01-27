package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class BigEvent {
    private String eventTitle;
    private String location;
    private String prize;
    private String date;
    private String teams;
}
