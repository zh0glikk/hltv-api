package parser;

import constants.urlDynamic;
import org.junit.jupiter.api.Test;

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

        topTeamsParser.getContent();
    }
}