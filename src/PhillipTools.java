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
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
