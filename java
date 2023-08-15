import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {

    private static final String[] words = {"apple", "dog", "cat", "book"};
    private static final int MAX_LIVES = 3;

    public static void main(String[] args) {
        Random random = new Random();
        String word = words[random.nextInt(words.length)].toLowerCase();
        String hiddenWord = "*".repeat(word.length());

        int lives = MAX_LIVES;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            boolean isCorrect = false;
            StringBuilder newHiddenWord = new StringBuilder(hiddenWord);

            for (int i = 0; i < word.length(); i++) {
                if (guess == word.charAt(i)) {
                    newHiddenWord.setCharAt(i, guess);
                    isCorrect = true;
                }
            }

            if (isCorrect) {
                hiddenWord = newHiddenWord.toString();
                System.out.println("Correct! The word now looks like: " + hiddenWord);
            } else {
                lives--;
                System.out.println("Incorrect! You have " + lives + " lives left.");
            }

            if (hiddenWord.equals(word)) {
                System.out.println("Congratulations! You won the game!");
                break;
            }

            if (lives <= 0) {
                System.out.println("Sorry, you lost the game. The word was: " + word);
                break;
            }
        }

        scanner.close();
    }
}
