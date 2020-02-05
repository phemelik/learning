package rekursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddiererTest {
    int a = 4;
    int b = 5;
    String c = "4";
    String d = "5";

    @Test
    void addierePrim() {
        assertEquals(9, Addierer.addierePrim(a, b));
    }

    @Test
    void addiereKaps() {
        assertEquals(9, Addierer.addiereKaps(c, d));
    }

    @Test
    void addiereRekursiv() {
        assertEquals(9, Addierer.addiereRekursiv(a, b));
    }
}