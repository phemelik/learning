package philliptools;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class PhillipToolsTest {

    InputStream example = new ByteArrayInputStream("24".getBytes());
    InputStream example1 = new ByteArrayInputStream("abc".getBytes());
    InputStream example2 = new ByteArrayInputStream("true".getBytes());
    String message = "Das ist ein Test.";

    @Test
    public void readInteger() {
        int parsedInteger = PhillipTools.readInteger(message, example);
        assertEquals(parsedInteger, 24);
    }

    @Test
    public void readString() {
        String parsedString = PhillipTools.readString(message, example1);
        assertEquals(parsedString, "abc");
    }

    @Test
    public void readBoolean() {
        Boolean parsedBoolean = PhillipTools.readBoolean(message, example2);
        assertEquals(parsedBoolean, true);
    }
}