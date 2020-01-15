import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {

    InputStream example = new ByteArrayInputStream("0".getBytes());
    String message = "Das ist ein Test.";

    @Test
    public void input() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TiktakPhillip.input(example);
        });
    }
}
