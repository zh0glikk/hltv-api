package parser;

import constants.urlConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchesParserTest {

    @Test
    public void testConstructorWithArgs() {
        MatchesParser matchesParser = new MatchesParser(urlConstants.MATCHES_TOP_TEAR_URL);

        assertNotNull(matchesParser.doc);
    }

    @Test
    public void testConstructor() {
        MatchesParser matchesParser = new MatchesParser();

        assertNotNull(matchesParser.doc);
    }

}