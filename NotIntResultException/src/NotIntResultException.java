public class NotIntResultException extends Exception {
    NotIntResultException(int dividend, int divisor) {
        super("" + dividend + "/" + divisor + " isn't an integer");
    }
}
