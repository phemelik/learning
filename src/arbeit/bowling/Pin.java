package arbeit.bowling;

public class Pin {
    private static String name = "Pin";
    private BowlingPin.pinState state = BowlingPin.pinState.STANDING;

    public Pin() {

    }

    public void changeState(BowlingPin.pinState state) {
        this.state = state;
    }

    public BowlingPin.pinState getState() {
        return state;
    }
}
