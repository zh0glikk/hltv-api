package parser;

import constants.urlConstants;
import model.BigEvent;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class EventsParser extends WebParser {

    public EventsParser() {
        this(urlConstants.EVENTS_URL);
    }

    public EventsParser(String URL) {
        super(URL);
    }

    @Override
    public List<BigEvent> getContent() {
        List<BigEvent> events = new ArrayList<>();

        Elements eventsMonth = doc.getElementsByClass("events-month");

        Elements bigEvents = eventsMonth.get(0).getElementsByClass("big-events");

        if (bigEvents != null) {
            for (Element el : bigEvents) {
                String eventTitle = this.getEventName(el);

                String location = this.getLocation(el);

                Elements table = this.getTable(el);

                String prize = this.getPrize(table);

                String date = this.getDate(table);

                String teams = this.getTeams(table);

                BigEvent bigEvent = new BigEvent(eventTitle, location, prize, date, teams);

                events.add(bigEvent);
            }
        }
        return events;
    }

    private String getEventName(Element el) {
        return el.getElementsByClass("big-event-name")
                .get(0)
                .text();
    }

    private String getLocation(Element el) {
        return el.getElementsByClass("big-event-location")
                .get(0)
                .text();
    }

    private Elements getTable(Element el) {
        return el.getElementsByClass("col-value");
    }

    private String getPrize(Elements table) {
        return table.get(1).text();
    }

    private String getDate(Elements table) {
        return table.get(0).text();
    }

    private String getTeams(Elements table) {
        return table.get(2).text();
    }
}
