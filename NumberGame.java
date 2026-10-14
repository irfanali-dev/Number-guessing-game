import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        String playAgain;

        System.out.println("=== NUMBER GUESSING GAME ===");

        do {
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("\nGuess a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid integer!");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Enter a number from 1 to 100.");
                    continue;
                }

                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You won!");
                    System.out.println("Attempts used: " + attempts);
                    score += maxAttempts - attempts + 1;
                    guessed = true;
                    break;
                } else if (guess < number) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }

                System.out.println("Attempts left: "
                        + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("Game over! The number was "
                        + number);
            }

            System.out.println("Your total score: " + score);
            System.out.print("Play again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing!");
        sc.close();
    }
}
