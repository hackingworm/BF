public class Test {
    public static void main(String[] args) {
        try {
            System.out.println("6/2 = " + IntegerArithmetics.intDiv(6, 3));
            System.out.println("5/2 = " + IntegerArithmetics.intDiv(5, 2));
        } catch (NotIntResultException nire) {
            System.out.println(nire.getMessage());
        }
    }
}
