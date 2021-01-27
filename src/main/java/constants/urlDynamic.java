package constants;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class urlDynamic {
    private static String TOP_TEAMS_URL = "https://www.hltv.org/ranking/teams/";

    public static String[] getLastMonday(LocalDate currentDate) {
        DayOfWeek dow = currentDate.getDayOfWeek();
        Month month = currentDate.getMonth();
        int year = currentDate.getYear();
        int date = currentDate.getDayOfMonth();

        if ( dow != DayOfWeek.MONDAY ) {
            int diff = dow.getValue() - DayOfWeek.MONDAY.getValue();

            date -= diff;
        }
        if ( date < 0 ) {
            month = currentDate.getMonth().minus(1);
            date += month.length(currentDate.isLeapYear());
        }

        return new String[]{String.valueOf(year),
                            month.toString().toLowerCase(),
                            String.valueOf(date)};
    }

    public static String getTopTeamsUrl() {
        String[] args = getLastMonday(LocalDate.now());

        String url = String.format(TOP_TEAMS_URL + "%s/%s/%s", args[0], args[1], args[2]);

        return url;
    }
}
