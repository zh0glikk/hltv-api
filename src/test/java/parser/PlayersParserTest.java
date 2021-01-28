package parser;

import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersParserTest {

    @Test
    public void testConstructor() {
        PlayersParser playersParser = new PlayersParser("https://www.hltv.org/player/7592/device");

        assertNotNull(playersParser.doc);
    }

    @Test
    public void testGettingContent() {
        PlayersParser playersParser = new PlayersParser("https://www.hltv.org/player/7592/device");

        Player player = playersParser.getContent().get(0);

        assertNotEquals(player.getRealName(), "");
        assertNotEquals(player.getNickName(), "");
        assertNotEquals(player.getAge(), "");
        assertNotEquals(player.getCurrentTeam(), "");

        assertNotEquals(player.getRating2_0(), 0.0);
        assertNotEquals(player.getKillsPerRound(), 0.0);
        assertNotEquals(player.getHeadshots(), "");
        assertNotEquals(player.getMapsPlayed(), 0);
        assertNotEquals(player.getDeathPerRound(), 0.0);



    }

}