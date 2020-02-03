package Bowling;

public class InvalidArgumentException extends Exception {

    public InvalidArgumentException() {
        super ("Die eingegebene Anzahl der Pins ist nicht valide!");
    }

}
