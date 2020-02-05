package periodicSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class PeriodicSystem {
    public static ChemicalElement[] elementArray = new ChemicalElement[119];
    public static ChemicalElement help;
    public static boolean[] aggregateArray = new boolean[elementArray.length];
    private static final PeriodicSystem obj = new PeriodicSystem();

    public static void elementSearch(int period, int group) throws NoElementException, InvalidPeriodGroupException {
        if (period < 1 || period > 18 || group < 1 || group > 4) {
            throw new InvalidPeriodGroupException();
        }
        for (ChemicalElement chemicalElement : elementArray) {
            if (chemicalElement != null) {
                if (chemicalElement.period == period && chemicalElement.group == group) {
                    help = chemicalElement;
                    break;
                }
            }
        }
        if (help != null) {
            System.out.println(help);
        } else {
            throw new NoElementException();
        }
    }

    public static void printSystem() {
        for (ChemicalElement chemicalElement : elementArray) {
            if (chemicalElement != null) {
                System.out.println(chemicalElement);
            }
        }
    }

    private PeriodicSystem() {
        Scanner scanIn = null;
        String InputLine = "";
        String xfileLocation = "Aufgaben/ps.csv";

        try {
            scanIn = new Scanner(new BufferedReader(new FileReader(xfileLocation)));

            while (scanIn.hasNextLine()) {
                InputLine = scanIn.nextLine();

                String[] InArray = InputLine.split(",");

                if (!InArray[0].equals("Ordnungszahl")) {
                    elementArray[Integer.parseInt(InArray[0])] = new ChemicalElement(Integer.parseInt(InArray[0]), InArray[1], InArray[2], Integer.parseInt(InArray[3]), Integer.parseInt(InArray[4]), InArray[5]);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < elementArray.length; i++) {
            if (elementArray[i] != null) {
                aggregateArray[i] = elementArray[i].aggregateState.equals("Gas");
            }
        }
    }

    public static PeriodicSystem getSystem() {
        return obj;
    }

    public static void main(String[] args) throws NoElementException, InvalidPeriodGroupException {
        printSystem();
        elementSearch(18, 1);
        System.out.println(ChemicalElement.isGas(1, aggregateArray));
        System.out.println(elementArray[76].isAlkali());
        System.out.println(elementArray[80].isLiquid());
        System.out.println(elementArray[76].compareTo(elementArray[80]));
    }
}
