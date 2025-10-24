import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {

        // play game until user exits
        do {
            int numOfGuesses = 0;
            int guess = 0;
            Scanner scanner = new Scanner(System.in);

            // generate a random number between 1 and 10

            Random generator = new Random();
            int randomNum = generator.nextInt(1, 11);
            System.out.println("Random number between 1-10: " + randomNum);

            // only allow 3 guesses
            for (int i = 1; i <= 3; i++) {

                // prevent invalid inputs
                do {
                    System.out.print("Guess the magic number between 1-10: ");
                    guess = scanner.nextInt();
                    numOfGuesses = i;
                }
                while (guess < 1 || guess > 10);

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
                System.out.println("Well done, you have won!");
            }
            else
            {
                System.out.println("Bad luck, you have lost!"
                        + "\nThe magic number was " + randomNum);
            }

            // ask if user wants to play again
            System.out.print("Do you want to play another game? ");

        }
        while (yes());
        //System.out.println("Good bye!");

    }

    // yes method
    static boolean yes() {
        Scanner scnr = new Scanner(System.in);

        for(;;)
        {
            System.out.println("yes or no? : ");
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
}
