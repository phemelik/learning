package periodicSystem;

public class NoElementException extends Exception {

    public NoElementException() {
        super("An dieser Stelle existiert kein Element!");
    }
}
