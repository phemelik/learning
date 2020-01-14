import java.io.InputStream;

public class TiktakPhillip {
    public static void main (String[] args) {

        output(input());

    }

    public static int input () {
        InputStream inputStream = System.in;

        /* while ( number <= 0 || number > 100 ) {
            if ( number <= 0 ) {
                number = PhillipTools.readInteger("Deine Zahl ist zu klein! Bitte gib eine natürliche Zahl zwischen 1 und 100 ein: ", inputStream);
            }
            if ( number > 100 ) {
                number = PhillipTools.readInteger("Deine Zahl ist zu groß! Bitte gib eine natürliche Zahl zwischen 1 und 100 ein: ", inputStream);
            }
        } */

        return PhillipTools.readInteger("Gib eine natürliche Zahl zwischen 1 und 100 ein: ", inputStream);
    }

    public static void output ( int number ) {
        String result;

        if ( number % 15 == 0 ) {
            result = "tiktak";
        } else if ( number % 5 == 0 ) {
            result = "tak";
        } else if ( number % 3 == 0 ) {
            result = "tik";
        } else {
            result = String.valueOf(number);
        }

        System.out.println(result);
    }
}
