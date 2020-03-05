package arbeit.diningphilosophers;

import java.util.Random;

public class Fork {

    public int forkId;
    private boolean status;

    Fork(int forkId) {
        this.forkId = forkId;
        this.status = true;
    }

    public synchronized void free() throws InterruptedException {

        status = true;

    }

    public synchronized boolean pick(int philosopherId) throws InterruptedException {

        int counter = 0;
        int waituntil = new Random(). nextInt(10) + 5;

        while (!status) {

            Thread.sleep(new Random().nextInt(100) + 50);

            counter++;

            if(counter > waituntil) {

                return false;

            }
        }

        status = false;

        return true;

    }
}
