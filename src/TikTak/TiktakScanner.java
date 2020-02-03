package TikTak;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TiktakScanner {
    public static void main (String[] args) {

        System.out.print("Gib eine natürliche Zahl zwischen 1 und 100 ein: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int zahl = Integer.parseInt(s);

        while ( zahl <= 0 || zahl > 100 ) {
            if ( zahl <= 0 ) {
                System.out.print("Deine Zahl ist zu klein! Bitte gib eine natürliche Zahl zwischen 1 und 100 ein: ");
                scanner = new Scanner(System.in);
                s = scanner.next();
                zahl = Integer.parseInt(s);
            }
            if ( zahl > 100 ) {
                System.out.print("Deine Zahl ist zu groß! Bitte gib eine natürliche Zahl zwischen 1 und 100 ein: ");
                scanner = new Scanner(System.in);
                s = scanner.next();
                zahl = Integer.parseInt(s);
            }
        }

        if ( zahl > 0 && zahl <= 100 ) {
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
}
