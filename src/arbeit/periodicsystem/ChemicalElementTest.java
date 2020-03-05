package arbeit.periodicsystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChemicalElementTest {

    ChemicalElement example1 = new ChemicalElement(1, "Hydrogen", "H", 1, 1, "Gas");
    ChemicalElement example2 = new ChemicalElement(3, "Lithium", "Li", 1, 2, "Alkali");
    ChemicalElement example3 = new ChemicalElement(35, "Bromine", "Br", 17, 4, "Liquid");
    boolean[] example4 = {true, false};

    @Test
    void isAlkali() {
        assertTrue(example2.isAlkali());
        assertFalse(example1.isAlkali());
    }

    @Test
    void isLiquid() {
        assertTrue(example3.isLiquid());
        assertFalse(example1.isLiquid());
    }

    @Test
    void isGas() {
        assertTrue(ChemicalElement.isGas(0, example4));
        assertFalse(ChemicalElement.isGas(1, example4));
    }

    @Test
    void compareTo() {
        assertEquals(0, example2.compareTo(example2));
        assertEquals(-1, example2.compareTo(example1));
        assertEquals(1, example2.compareTo(example3));
    }
}