package Task1;
import java.util.Scanner;
import java.util.Random;
public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attempts = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("A random number between " + minRange + " and " + maxRange + " has been generated.");

            int remainingAttempts = attempts;
            boolean guessedCorrectly = false;
            while (remainingAttempts > 0 && !guessedCorrectly) {
                System.out.println("You have " + remainingAttempts + " attempts left.");
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); 

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    score += remainingAttempts; 
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                remainingAttempts--;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you ran out of attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.nextLine();
            if (!playChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Your final score is: " + score);
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
