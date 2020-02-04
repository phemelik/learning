package Rekursion;

public class Palindrom {

    public static boolean palindromSchleife(char[] palindrom) {
        int end = palindrom.length - 1;
        for(int i = 0; i < end; i++) {
            if(palindrom[i] == palindrom[end]) {
                end = end -1;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean palindromRekursiv(char[] palindrom) {
        return palindromRekursiv(palindrom, 0, palindrom.length - 1);
    }

    public static boolean palindromRekursiv(char[] palindrom, int start, int end) {
        if(start >= end) {
            return true;
        } else if(palindrom[start] == palindrom[end]) {
            return palindromRekursiv(palindrom, start + 1, end - 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        char[] palindrom = {'a', 'b', 'c', 'd', 'c', 'b', 'a'};
        System.out.println(palindromSchleife(palindrom));
        System.out.println(palindromRekursiv(palindrom));
    }
}
