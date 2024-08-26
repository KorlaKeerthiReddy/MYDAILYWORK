import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int attempts = 5; // Limiting the number of attempts
            int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            boolean correctGuess = false;
            
            System.out.println("Guess the number between 1 and 100. You have " + attempts + " attempts.");

            while (attempts > 0 && !correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    correctGuess = true;
                    score++;
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
                
                attempts--;
                if (!correctGuess && attempts > 0) {
                    System.out.println("You have " + attempts + " attempts left.");
                }
            }

            if (!correctGuess) {
                System.out.println("You've run out of attempts. The correct number was " + randomNumber);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine();  // consume newline
            String response = scanner.nextLine();
            
            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game over! Your final score is: " + score);
        scanner.close();
    }
}
