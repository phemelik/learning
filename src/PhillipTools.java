import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PhillipTools {

    public static int readInteger ( String m ) {
        return Integer.parseInt(reading(m));
    }

    public static String readString ( String m ) {
        return reading(m);
    }

    public static boolean readBoolean ( String m ) {
        return Boolean.parseBoolean(reading(m));
    }

    private static String reading ( String m ) {
        System.out.print(m);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
