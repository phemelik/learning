package arbeit.rekursion;

import static java.lang.Integer.parseInt;

public class Addierer {

    public static int addierePrim(int a, int b) {
        return a + b;
    }

    public static int addiereKaps(String a, String b) {
        int first = parseInt(a);
        int second = parseInt(b);
        return first + second;
    }

    public static int addiereRekursiv(int a, int b) {
        if (b > 0) {
            a = a + 1;
            return addiereRekursiv(a, b-1);
        } else {
            return a;
        }
    }

    public static void main(String[] args) {
        System.out.println(addierePrim(4,7));
        System.out.println(addiereKaps("3", "9"));
        System.out.println(addiereRekursiv(5, 4));
    }
}
