package parser;

import constants.urlConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class EventsParserTest {

    @Test
    public void testConstructorWithArgs() {
        EventsParser eventsParser = new EventsParser(urlConstants.EVENTS_URL);

        assertNotNull(eventsParser.doc);
    }

    @Test
    public void testConstructor() {
        EventsParser eventsParser = new EventsParser();

        assertNotNull(eventsParser.doc);
    }

    @Test
    public void testGettingContent() {
        EventsParser eventsParser = new EventsParser();

        System.out.println(eventsParser.getContent());

//        assertDoesNotThrow();
    }

}