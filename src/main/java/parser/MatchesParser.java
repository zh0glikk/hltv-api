package parser;

import constants.stateConstants;
import constants.urlConstants;
import model.Match;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchesParser extends WebParser{

    public MatchesParser() {
        this(urlConstants.MATCHES_TOP_TEAR_URL);
    }

    public MatchesParser(String URL) {
        super(URL);
    }

    @Override
    public List<Match> getContent() {
        List<Match> matches = new ArrayList<Match>();

        Element todayMatches = doc.getElementsByClass("upcomingMatchesSection").get(0);
        Elements elements = todayMatches.getElementsByClass("upcomingMatch");

        for ( Element el: elements ) {
            String time = this.getTime(el);

            String team1 = this.getTeam1(el);
            String team2 = this.getTeam2(el);

            String tournament = this.getTournament(el);

            String matchMeta = this.getMatchMeta(el);

            int matchRating = this.getMatchRating(el);

            Match match = new Match(time, team1, team2, tournament, matchMeta, matchRating);

            matches.add(match);
        }
        return matches;
    }

    private String getTime(Element el) {
        return el.getElementsByClass("matchTime").get(0).text();
    }

    private String getTeam1(Element el) {
        return el.getElementsByClass("team1").get(0).text();
    }

    private String getTeam2(Element el) {
        return el.getElementsByClass("team2").get(0).text();
    }

    private String getTournament(Element el) {
        return el.getElementsByClass("matchEventName").get(0).text();
    }

    private String getMatchMeta(Element el) {
        return el.getElementsByClass("matchMeta").get(0).text();
    }

    private int getMatchRating(Element el) {
        return stateConstants.MAX_MATCH_RATING - el.getElementsByClass("faded").size();
    }
}
