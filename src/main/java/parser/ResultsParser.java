package parser;

import constants.stateConstants;
import constants.urlConstants;
import model.Result;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultsParser extends WebParser{

    public ResultsParser() {
        this(urlConstants.BIG_RESULTS_URL);
    }

    public ResultsParser(String URL) {
        super(URL);
    }

    @Override
    public List<Result> getContent() {
        List<Result> results = new ArrayList<>();

        Elements resultsParent = doc.getElementsByClass("results-sublist");

        Elements elements = resultsParent.get(0).getElementsByClass("result-con");

        for ( Element el : elements ) {
            String event = this.getEvent(el);

            String team1 = this.getTeam1(el);

            String team2 = this.getTeam2(el);

            String resultScore = this.getResultScore(el);

            int matchRating = this.getMatchRating(el);

            Result result = new Result(team1, team2, resultScore, event, matchRating);

            results.add(result);
        }
        return results;
    }

    private String getEvent(Element el) {
        return el.getElementsByClass("event")
                .get(0)
                .getElementsByClass("event-name")
                .get(0)
                .text();
    }

    private String getTeam1(Element el) {
        return el.getElementsByClass("team-cell")
                .get(0)
                .getElementsByClass("team")
                .get(0)
                .text();
    }

    private String getTeam2(Element el) {
        return el.getElementsByClass("team-cell")
                .get(1)
                .getElementsByClass("team")
                .get(0)
                .text();
    }

    private String getResultScore(Element el) {
        return el.getElementsByClass("result-score")
                .get(0)
                .text();
    }

    private int getMatchRating(Element el) {
        return stateConstants.MAX_MATCH_RATING - el.getElementsByClass("faded").size();
    }
}
