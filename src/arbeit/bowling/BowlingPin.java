package arbeit.bowling;

import java.io.InputStream;
import java.util.Random;

import arbeit.philliptools.PhillipTools;

public class BowlingPin {

    private static String answer;
    private static Pin[] game;

    public enum pinState {
        STANDING,
        RECLINING;

        private static final pinState[] VALUES = values();
        private static final int SIZE = VALUES.length;
        private static final Random RANDOM = new Random();

        public static pinState getRandomState() {
            return VALUES[RANDOM.nextInt(SIZE)];
        }
    }

    public static Pin[] getGame() {
        return game;
    }

    public static void question() {
        InputStream inputStream = System.in;
        answer = PhillipTools.readString("Willst du eine eigene Anzahl an Pins eingeben? (ja/nein)", inputStream);

        while (!answer.equals("ja") && !answer.equals("nein")) {
            inputStream = System.in;
            answer = PhillipTools.readString("Willst du eine eigene Anzahl an Pins eingeben? (ja/nein)", inputStream);
        }
    }

    public static void bowlingGame() {
        int numberOfPins = 10;
        bowlingGame(numberOfPins);
    }

    public static void bowlingGame(int numberOfPins) {
        game = new Pin[numberOfPins];
        for (int i = 0; i < game.length; i++) {
            game[i] = new Pin();
        }
        if (numberOfPins == 3) {
            System.out.println(" !");
            System.out.println("! !");
        } else if (numberOfPins == 6) {
            System.out.println("  !");
            System.out.println(" ! !");
            System.out.println("! ! !");
        } else if (numberOfPins == 10) {
            System.out.println("   !");
            System.out.println("  ! !");
            System.out.println(" ! ! !");
            System.out.println("! ! ! !");
        } else if (numberOfPins == 15) {
            System.out.println("    !");
            System.out.println("   ! !");
            System.out.println("  ! ! !");
            System.out.println(" ! ! ! !");
            System.out.println("! ! ! ! !");
        }
    }

    public static void startGame() throws InvalidArgumentException {
        question();
        if (answer.equals("ja")) {
            InputStream inputStream = System.in;
            int numberOfPins = PhillipTools.readInteger("Mit wie vielen Pins möchtest du spielen? (3/6/10/15)", inputStream);

            if (numberOfPins != 3 && numberOfPins != 6 && numberOfPins != 10 && numberOfPins != 15) {
                throw new InvalidArgumentException();
            }
         /* while ( numberOfPins != 3 && numberOfPins != 6 && numberOfPins != 10 && numberOfPins != 15 ) {
                inputStream = System.in;
                numberOfPins = PhillipTools.readInteger("Mit wie vielen Pins möchtest du spielen? (3/6/10/15)", inputStream);
            } */
            bowlingGame(numberOfPins);
        } else {
            bowlingGame();
        }
    }

    public static void putUp(int pin) {
        game[pin].changeState(pinState.STANDING);
    }

    public static void upset(int pin) {
        game[pin].changeState(pinState.RECLINING);
    }

    public static void reset() {
        for (Pin pin : game) {
            pin.changeState(pinState.STANDING);
        }
    }

    public static void rollBall() {
        for (Pin pin : game) {
            if (pin.getState().equals(pinState.STANDING)) {
                pin.changeState(pinState.getRandomState());
            }
        }
    }

    public static int pinsStanding() {
        int number = 0;
        for (Pin pin : game) {
            if (pin.getState().equals(pinState.STANDING)) {
                number = number + 1;
            }
        }
        if (number > 1) {
            System.out.println("Es stehen noch " + number + " Pins.");
        } else {
            System.out.println("Es steht noch " + number + " Pin.");
        }
        return number;
    }

    public static int pinsOverturned() {
        int number = 0;
        for (Pin pin : game) {
            if (pin.getState().equals(pinState.RECLINING)) {
                number ++;
            }
        }
        if (number > 1) {
            System.out.println("Es sind " + number + " Pins umgefallen.");
        } else {
            System.out.println("Es ist " + number + " Pin umgefallen.");
        }
        return number;
    }

    public static void main(String[] args) throws InvalidArgumentException {
        startGame();
        rollBall();
        pinsStanding();
        pinsOverturned();
        rollBall();
        pinsStanding();
        pinsOverturned();
    }
}