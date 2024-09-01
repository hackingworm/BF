public class IntegerArithmetics {
    public static int intDiv(int dividend, int divisor) throws NotIntResultException {
        if (0 != dividend % divisor) {
            throw new NotIntResultException(dividend, divisor);
        }

        return dividend / divisor;
    }
}
