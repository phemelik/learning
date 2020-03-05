package arbeit.bowling;

import arbeit.philliptools.PhillipTools;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class BowlingPinTest {

    InputStream example = new ByteArrayInputStream("hallo".getBytes());
    String message = "Das ist ein Test.";

    @Test
    void question() {
        String parsedString = PhillipTools.readString(message, example);
        assertEquals(parsedString, "hallo");
    }

    @Test
    void bowlingGameWithDefault() {
        BowlingPin.bowlingGame();
        assertEquals(10, BowlingPin.getGame().length);
    }

    @Test
    void bowlingGame() {
        BowlingPin.bowlingGame(15);
        assertEquals(15, BowlingPin.getGame().length);
    }

    @Test
    void putUp() {
        BowlingPin.bowlingGame(15);
        BowlingPin.upset(5);
        BowlingPin.putUp(5);
        Pin[] game = BowlingPin.getGame();
        assertEquals(BowlingPin.pinState.STANDING, game[5].getState());
    }

    @Test
    void upset() {
        BowlingPin.bowlingGame(15);
        BowlingPin.upset(5);
        Pin[] game = BowlingPin.getGame();
        assertEquals(BowlingPin.pinState.RECLINING, game[5].getState());
    }

    @Test
    void reset() {
        BowlingPin.bowlingGame(10);
        BowlingPin.upset(5);
        BowlingPin.upset(8);
        Pin[] game = BowlingPin.getGame();
        BowlingPin.reset();
        assertEquals(BowlingPin.pinState.STANDING, game[5].getState());
        assertEquals(BowlingPin.pinState.STANDING, game[8].getState());
    }

    @Test
    void pinsStanding() {
        BowlingPin.bowlingGame(10);
        Pin[] game = BowlingPin.getGame();
        assertEquals(10, BowlingPin.pinsStanding());
    }

    @Test
    void pinsOverturned() {
        BowlingPin.bowlingGame(10);
        Pin[] game = BowlingPin.getGame();
        BowlingPin.upset(2);
        BowlingPin.upset(4);
        BowlingPin.upset(6);
        assertEquals(3, BowlingPin.pinsOverturned());
    }
}