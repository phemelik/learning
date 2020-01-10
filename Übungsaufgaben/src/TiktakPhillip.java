import java.util.Scanner;

public class TiktakPhillip {
    public static void main (String[] args) {

        int zahl = PhillipTools.readInteger("Gib eine natürliche Zahl zwischen 1 und 100 ein: ");

        while ( zahl <= 0 || zahl > 100 ) {
            if ( zahl <= 0 ) {
                zahl = PhillipTools.readInteger("Deine Zahl ist zu klein! Bitte gib eine natürliche Zahl zwischen 1 und 100 ein: ");
            }
            if ( zahl > 100 ) {
                zahl = PhillipTools.readInteger("Deine Zahl ist zu groß! Bitte gib eine natürliche Zahl zwischen 1 und 100 ein: ");
            }
        }

        if ( zahl % 15 == 0 ) {
            System.out.println("tiktak");
        } else if ( zahl % 5 == 0 ) {
            System.out.println("tak");
        } else if ( zahl % 3 == 0 ) {
            System.out.println("tik");
        } else {
            System.out.println(zahl);
        }
    }
}
