package parser;

import constants.urlDynamic;
import model.TopTeam;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopTeamsParserTest {

    @Test
    public void testConstructorWithArgs() {
        TopTeamsParser topTeamsParser = new TopTeamsParser(urlDynamic.getTopTeamsUrl());

        assertNotNull(topTeamsParser.doc);
    }

    @Test
    public void testConstructor() {
        TopTeamsParser topTeamsParser = new TopTeamsParser();

        assertNotNull(topTeamsParser.doc);
    }

    @Test
    public void testGetContent() {
        TopTeamsParser topTeamsParser = new TopTeamsParser();

        List<TopTeam> topTeamList = topTeamsParser.getContent();

        for ( TopTeam topTeam : topTeamList ) {
            System.out.println(topTeam);
        }
    }
}