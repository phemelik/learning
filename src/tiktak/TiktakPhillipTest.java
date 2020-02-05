package tiktak;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class TiktakPhillipTest {

    InputStream example = new ByteArrayInputStream("0".getBytes());
    String message = "Das ist ein Test.";

    @Test
    public void input() {
        Assertions.assertThrows(TiktakPhillipException.class, () -> {
            TiktakPhillip.input(example);
        });
    }
}
