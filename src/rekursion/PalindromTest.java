package rekursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromTest {
    char[] palindrom1 = {'a', 'b', 'c', 'b', 'a'};
    char[] palindrom2 = {'a', 'b', 'c', 'c', 'a'};
    int start = 0;
    int end = 4;

    @Test
    void palindromSchleife() {
        assertTrue(Palindrom.palindromSchleife(palindrom1));
        assertFalse(Palindrom.palindromSchleife(palindrom2));
    }

    @Test
    void palindromRekursiv() {
        assertTrue(Palindrom.palindromRekursiv(palindrom1));
        assertFalse(Palindrom.palindromRekursiv(palindrom2));
    }

    @Test
    void testPalindromRekursiv() {
        assertTrue(Palindrom.palindromRekursiv(palindrom1, start, end));
        assertFalse(Palindrom.palindromRekursiv(palindrom2, start, end));
    }
}