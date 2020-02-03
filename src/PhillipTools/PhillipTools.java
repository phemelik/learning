package PhillipTools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PhillipTools {

    public static int readInteger(String message, InputStream a) {
        return Integer.parseInt(reading(message, a));
    }

    public static String readString(String message, InputStream a) {
        return reading(message, a);
    }

    public static boolean readBoolean(String message, InputStream a) {
        return Boolean.parseBoolean(reading(message, a));
    }

    private static String reading(String message, InputStream a) {
        System.out.print(message);
        BufferedReader reader = new BufferedReader(new InputStreamReader(a));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
