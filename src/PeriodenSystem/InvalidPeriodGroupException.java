package PeriodenSystem;

public class InvalidPeriodGroupException extends Exception {

    public InvalidPeriodGroupException() {
        super ("Die Periode oder Gruppe existiert nicht!");
    }
}
