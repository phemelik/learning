package arbeit.towerofhanoi;

import arbeit.philliptools.PhillipTools;
import java.io.InputStream;

public class TowerOfHanoi {

    public static char start = 'A', help = 'B', end = 'C';
    public static int numberOfPieces;

    public static int readIn() {
        int numberOfPieces = 0;
        InputStream inputStream = System.in;
        numberOfPieces = PhillipTools.readInteger("Gib die Anzahl der Scheiben ein ( > 0 ): ", inputStream);
        while (numberOfPieces <= 0) {
            inputStream = System.in;
            numberOfPieces = PhillipTools.readInteger("Deine Eingabe war ungültig! Gib eine neue Anzahl > 0 ein: ", inputStream);
        }

        return numberOfPieces;
    }

    public static void printOutSteps(int numberOfPieces) {
        double steps = Math.pow(2, numberOfPieces) - 1;
        System.out.println();
        System.out.println("Es wurden " + Math.round(steps) + " Schritte benötigt.");
    }

    public static void printOutTime(int numberOfPieces) {
        double steps = Math.pow(2, numberOfPieces) - 1;
        int sec = (int) Math.round(steps);
        int minute = sec / 60;
        int stunde = minute / 60;
        int tag = stunde / 24;
        int jahr = tag / 365;

        System.out.println();
        if (jahr == 1) {
            System.out.println("Das umstapeln des Turms mit " +  numberOfPieces + " Scheiben, hat " + jahr + " Jahr, " + tag % 365 + " Tage, " + stunde % 24 + " Stunden, " + minute % 60 + " Minuten und " + sec % 60 + " Sekunden gedauert.");
        } else if (jahr > 1) {
            System.out.println("Das umstapeln des Turms mit " +  numberOfPieces + " Scheiben, hat " + jahr + " Jahre, " + tag % 365 + " Tage, " + stunde % 24 + " Stunden, " + minute % 60 + " Minuten und " + sec % 60 + " Sekunden gedauert.");
        } else if (jahr == 0 && tag == 1) {
            System.out.println("Das umstapeln des Turms mit " +  numberOfPieces + " Scheiben, hat " + tag % 365 + " Tag, " + stunde % 24 + " Stunden, " + minute % 60 + " Minuten und " + sec % 60 + " Sekunden gedauert.");
        } else if (jahr == 0 && tag > 1) {
            System.out.println("Das umstapeln des Turms mit " +  numberOfPieces + " Scheiben, hat " + tag % 365 + " Tage, " + stunde % 24 + " Stunden, " + minute % 60 + " Minuten und " + sec % 60 + " Sekunden gedauert.");
        } else if (jahr == 0 && tag == 0 && stunde == 1) {
            System.out.println("Das umstapeln des Turms mit " +  numberOfPieces + " Scheiben, hat " + stunde % 24 + " Stunde, " + minute % 60 + " Minuten und " + sec % 60 + " Sekunden gedauert.");
        } else if (jahr == 0 && tag == 0 && stunde > 1) {
            System.out.println("Das umstapeln des Turms mit " +  numberOfPieces + " Scheiben, hat " + stunde % 24 + " Stunden, " + minute % 60 + " Minuten und " + sec % 60 + " Sekunden gedauert.");
        } else if (jahr == 0 && tag == 0 && stunde == 0 && minute == 1) {
            System.out.println("Das umstapeln des Turms mit " +  numberOfPieces + " Scheiben, hat " + minute % 60 + " Minute und " + sec % 60 + " Sekunden gedauert.");
        } else if (jahr == 0 && tag == 0 && stunde == 0 && minute > 1) {
            System.out.println("Das umstapeln des Turms mit " +  numberOfPieces + " Scheiben, hat " + minute % 60 + " Minuten und " + sec % 60 + " Sekunden gedauert.");
        } else if (jahr == 0 && tag == 0 && stunde == 0 && minute == 0) {
            System.out.println("Das umstapeln des Turms mit " +  numberOfPieces + " Scheiben, hat " + sec % 60 + " Sekunden gedauert.");
        }
    }

    public static void play(int numberOfPieces, char start, char end, char help) {
        if (numberOfPieces > 0) {
            play(numberOfPieces - 1, start, help, end);

            System.out.println("Die Scheibe " + numberOfPieces + " wird von Platz " + start + " nach Platz " + end + " umgestapelt.");

            play(numberOfPieces - 1, help, end, start);
        }
    }

    public static void main(String[] args) {
        numberOfPieces = readIn();
        play(numberOfPieces, start, end, help);
        printOutSteps(numberOfPieces);
        printOutTime(numberOfPieces);
    }
}
