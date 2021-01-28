package parser;

import constants.urlDynamic;
import model.Result;
import model.TopTeam;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class TopTeamsParser extends WebParser{

    public TopTeamsParser() {
        this(urlDynamic.getTopTeamsUrl());
    }

    public TopTeamsParser(String URL) {
        super(URL);
    }

    @Override
    public List<TopTeam> getContent() {
        List<TopTeam> topTeams = new ArrayList<>();

        Elements elements = doc.getElementsByClass("ranked-team");

        for ( Element el : elements ) {
            String position = this.getPosition(el);

            String name = this.getName(el);

            String points = this.getPoints(el);

            List<String> players = this.getPlayers(el);
            List<String> urls = this.getUrls(el);

            TopTeam topTeam = new TopTeam(position, name, points, players, urls);
            topTeams.add(topTeam);
        }

        return topTeams;
    }

    private String getPosition(Element el) {
        return el.getElementsByClass("position")
                .get(0)
                .text();
    }

    private String getName(Element el) {
        return el.getElementsByClass("name")
                .get(0)
                .text();
    }

    private String getPoints(Element el) {
        return el.getElementsByClass("points")
                .get(0)
                .text();
    }

    private List<String> getUrls(Element el) {
        List<String> urls = new ArrayList<>();
        Elements playersEl = el.getElementsByClass("player-holder");

        for ( Element element : playersEl ) {
            String url = element.getElementsByClass("pointer").attr("href");

            urls.add(url);
        }
        return urls;
    }

    private List<String> getPlayers(Element el) {
        List<String> players = new ArrayList<>();
        Elements playersEl = el.getElementsByClass("player-holder");

        for ( Element element : playersEl ) {
            String[] urlParts = element.getElementsByClass("pointer").attr("href").split("/");

            players.add(urlParts[3]);
        }
        return players;
    }


}
