package periodicSystem;

public class ChemicalElement implements Comparable {
    public final int atomicNumber, period, group;
    public final String name, symbol, aggregateState;

    public ChemicalElement(int atomicNumber, String name, String symbol, int period, int group, String aggregateState) {
        this.atomicNumber = atomicNumber;
        this.period = period;
        this.group = group;
        this.symbol = symbol;
        this.name = name;
        this.aggregateState = aggregateState;
    }

    public boolean isAlkali() {
        switch (aggregateState) {
            case "Alkali":
            case "EarthAlkali":
                return true;
            default:
                return false;
        }
    }

    public boolean isLiquid() {
        return aggregateState.equals("Liquid");
    }

    public static boolean isGas(int atomicNumber, boolean[] aggregateArray) {
        return aggregateArray[atomicNumber];
    }

    @Override
    public String toString() {
        return this.atomicNumber + " | " + this.name + " | " + this.symbol + " | " + this.period + " | " + this.group + " | " + this.aggregateState;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(((ChemicalElement) o).atomicNumber, this.atomicNumber);
    }
}
