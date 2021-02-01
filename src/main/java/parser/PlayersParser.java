package parser;

import model.Player;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;



import java.util.ArrayList;
import java.util.List;

public class PlayersParser extends WebParser {

    public PlayersParser(String URL) {
        super(URL);
    }

    @Override
    public List<Player> getContent() {
        List<Player> players = new ArrayList<>();

        Elements playerContainer = doc.getElementsByClass("playerContainer");


        String nickName = this.getNickName(playerContainer);

        String realName = this.getRealName(playerContainer);

        String age = this.getAge(playerContainer);

        String currentTeam = this.getCurrentTeam(playerContainer);


        Elements statsContainer = this.getStatsContainer(doc);

        float rating2_0 = this.getRating2_0(statsContainer);

        float killsPerRound = this.getKillsPerRound(statsContainer);

        String headshots = this.getHeadshots(statsContainer);

        int mapsPlayed = this.getMapsPlayed(statsContainer);

        float deathPerRound = this.getDeathPerRound(statsContainer);

        String photoUrl = this.getPhotoUrl(playerContainer);

        Player player = new Player(
                nickName,
                realName,
                age,
                currentTeam,
                rating2_0,
                killsPerRound,
                headshots,
                mapsPlayed,
                deathPerRound,
                photoUrl
        );

        players.add(player);

        return players;
    }

    private String getNickName(Elements playerContainer) {
        return playerContainer.get(0)
                .getElementsByClass("playerName")
                .get(0)
                .getElementsByClass("playerNickname")
                .get(0)
                .text();
    }

    private String getRealName(Elements playerContainer) {
        return playerContainer.get(0)
                .getElementsByClass("playerName")
                .get(0)
                .getElementsByClass("playerRealname")
                .get(0)
                .text();
    }

    private String getAge(Elements playerContainer) {
        return playerContainer.get(0)
                .getElementsByClass("playerInfo")
                .get(0)
                .getElementsByClass("playerAge")
                .get(0)
                .getElementsByClass("listRight")
                .get(0)
                .text();
    }

    private String getCurrentTeam(Elements playerContainer) {
        return playerContainer.get(0)
                .getElementsByClass("playerTeam")
                .get(0)
                .getElementsByClass("listRight")
                .get(0)
                .getElementsByTag("span")
                .get(0)
                .text();
    }

    private Elements getStatsContainer(Document doc) {
        return doc.getElementsByClass("stats-matches")
                .get(0)
                .getAllElements()
                .get(0)
                .getElementsByClass("playerpage-container")
                .get(0)
                .getElementsByClass("player-stat");
    }

    private float getRating2_0(Elements statsContainer) {
        return Float.parseFloat(statsContainer.get(0)
                .getElementsByClass("statsVal")
                .get(0)
                .text());
    }

    public float getKillsPerRound(Elements statsContainer) {
        return Float.parseFloat(statsContainer.get(1)
                .getElementsByClass("statsVal")
                .get(0)
                .text());
    }

    public String getHeadshots(Elements statsContainer) {
        return statsContainer.get(2)
                .getElementsByClass("statsVal")
                .get(0)
                .text();
    }

    public int getMapsPlayed(Elements statsContainer) {
        return Integer.parseInt(statsContainer.get(3)
                .getElementsByClass("statsVal")
                .get(0)
                .text());
    }

    public float getDeathPerRound(Elements statsContainer) {
        return Float.parseFloat(statsContainer.get(4)
                .getElementsByClass("statsVal")
                .get(0)
                .text());
    }

    public String getPhotoUrl(Elements playerContainer) {
        return playerContainer.get(0)
                .getElementsByClass("playerBodyshot")
                .get(0)
                .getElementsByClass("bodyshot-img")
                .get(0)
                .attr("src");
    }
}
