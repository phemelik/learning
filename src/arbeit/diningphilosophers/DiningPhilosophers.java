package arbeit.diningphilosophers;

import java.util.Scanner;

public class DiningPhilosophers {

    Philosopher[] philosophers;
    Fork[] forks;
    Thread[] threads;

    Scanner scan;
    int number;

    public static void main(String[] args) {

        DiningPhilosophers obj = new DiningPhilosophers();
        obj.init();
        obj.startThinkingEating();

    }

    public void init() {
         scan = new Scanner(System.in);

         System.out.println("Dining Philosophers Problem.");

         try {

             System.out.println("Enter the number of Philosophers.");
             number = scan.nextInt();

             if(number < 2) {

                 System.out.println("Number must be greater than 1.");
                 return;

             }

         } catch (Exception e) {

             System.out.println("You must enter an integer.");

         }

         philosophers = new Philosopher[number];
         forks = new Fork[number];
         threads = new Thread[number];

         for (int i = 0; i < number; i++) {

             philosophers[i] = new Philosopher(i+1);
             forks[i] = new Fork(i+1);

         }
    }

    public void startThinkingEating() {

        for (int i = 0; i < number; i++) {
            final int index = i;

            threads[i] = new Thread(new Runnable() {

                @Override
                public void run() {

                    try {

                        philosophers[index].start(forks[index], (index - 1 > 0) ? forks[index - 1] : forks[number - 1]);

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }
                }
            });

            threads[i].start();


        }
    }
}


