import java.util.Random;
import java.util.Scanner;

public class Ex1b {

    public static void main(String[] args) {

        // instantiate scanner object
        Scanner scanner = new Scanner(System.in);
        Random generator = new Random();
        int guess = 0;
        double gamesPlayed = 0;
        double gamesWon = 0;

        // play game until user exits
        do {
            gamesWon = playGame(generator, scanner, guess, gamesWon);
            gamesPlayed++;
        }
        while (yes("Do you want to play another game?", scanner));

        System.out.println("You have won " + percentageWon(gamesWon, gamesPlayed) + "% of games");

    }


    // yes method
    static boolean yes(String prompt, Scanner scnr)
    {

        for(;;)
        {
            System.out.println(prompt);
            String str = scnr.next();

            if (str.equals("yes"))
            {
                return true;
            }
            else if (str.equals("no"))
            {
                return false;
            }

        }

    }


    static int enterNumber(int min, int max, Scanner scnr, int guess)
    {
        do {
            System.out.print("Guess the magic number between 1-10: ");
            guess = scnr.nextInt();
        }
        while (guess < min || guess > max);

        return guess;
    }


    static double playGame(Random generator, Scanner scanner, int guess, double gamesWon)
    {

        // generate a random number between 1 and 10
        int randomNum = generator.nextInt(1, 11);
        System.out.println("Random number between 1-10: " + randomNum);

        // only allow 3 guesses
        for (int i = 1; i <= 3; i++) {

            // prevent invalid inputs
            guess = enterNumber(1, 10, scanner, guess);

            // ouput statement based on input
            if (guess > randomNum)
            {
                System.out.println("too high!");
            }
            else if (guess < randomNum)
            {
                System.out.println("too low!");
            }

            // exit loop early if guess was correct
            else if (guess == randomNum)
            {
                System.out.println("Correct!");
                break;
            }
        }

        if (guess == randomNum)
        {
            gamesWon++;
            System.out.println("Well done, you have won!");
        }
        else
        {
            System.out.println("Bad luck, you have lost!"
                    + "\nThe magic number was " + randomNum);
        }

        return gamesWon;
    }


    static double percentageWon(double gamesWon, double gamesPlayed)
    {
        return (gamesWon / gamesPlayed) * 100;
    }


}

