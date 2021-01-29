package parser;

import constants.urlConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultsParserTest {

    @Test
    public void testConstructorWithArgs() {
        ResultsParser resultsParser = new ResultsParser(urlConstants.BIG_RESULTS_URL);

        assertNotNull(resultsParser.doc);
    }

    @Test
    public void testConstructor() {
        ResultsParser resultsParser = new ResultsParser();

        assertNotNull(resultsParser.doc);
    }

    @Test
    public void output() {
        ResultsParser resultsParser = new ResultsParser();

        assertNotNull(resultsParser.getContent());
    }

}