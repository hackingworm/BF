import java.util.*;

public class GuessingGame {
    private int anwser;
    private Random generator;
    private boolean gameOver;
    private int differential;
    private int max;
    private int maxGuessesAllowed;
    private int numGuessesTaken;

    GuessingGame() {
        this(0);
    }

    GuessingGame(int max) {
        this.max = max;
        generator = new Random();
    }

    public void newGame(int maxGuessesAllowed) {
        this.maxGuessesAllowed = maxGuessesAllowed;
        anwser = generator.nextInt(max + 1);
        gameOver = false;
        differential = max;
        numGuessesTaken = 0;
    }

    public void guess() {
        Scanner scanner = new Scanner(System.in);
        int num;
        for (;;) {
            System.out.println("Enter your guess, remember it must be between 0 and " + max);
            num = scanner.nextInt();
            if (0 <= num && max >= num) {
                break;
            }
            System.out.println("Guess out of range, the guess must be between 0 and " + max);
        }

        if (anwser == num) {
            gameOver = true;
            System.out.println("Congratulation");
            return;
        }

        int diff;
        if (anwser < num) {
            System.out.println("Too High");
            diff = num - anwser;
        } else {
            System.out.println("Too low");
            diff = anwser - num;
        }

        if (differential < diff) {
            System.out.println("Getting colder");
        } else if (differential > diff) {
            System.out.println("Getting warmer");
        }

        differential = diff;

        if (maxGuessesAllowed == ++numGuessesTaken) {
            System.out.println("Maximum number of guesses allowed reached");
            gameOver = true;
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }
}