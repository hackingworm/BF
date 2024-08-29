import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Guessing Game");
        for (;;) {
            int num;

            // "Enter the maximum number":
            for (;;) {
                System.out.println("Enter the maximum number");
                if (0 < (num = scanner.nextInt())) {
                    break;
                }

                System.out.println(num + " is illegal, please choose another one");
            }

            GuessingGame game = new GuessingGame(num);

            // "Enter the number of guess allowed":
            for (;;) {
                System.out.println("Enter the number of guess allowed");
                if (0 < (num = scanner.nextInt())) {
                    break;
                }

                System.out.println(num + " is illegal, please choose another one");
            }

            game.newGame(num);

            while (!game.isGameOver()) {
                game.guess();
            }

            // "Would you like to play again, enter Y for yes, N for no"
            System.out.println("Would you like to play again, enter Y for yes, No for no");
            char reply = scanner.next().charAt(0);
            if ('Y' != reply && 'y' != reply) {
                break;
            }
        }
    }
}