public class Test {
    public static void main(String[] args) {
        Int i = Int.valueOf(0);
        System.out.println(i.intValue() + "/" + i.shortValue());

        i = Int.valueOf(1);
        System.out.println(i.intValue() + "/" + i.shortValue());

        i = Int.valueOf(32767);
        System.out.println(i.intValue() + "/" + i.shortValue());

        i = Int.valueOf(32768);
        System.out.println(i.intValue() + "/" + i.shortValue());

        i = Int.valueOf(32769);
        System.out.println(i.intValue() + "/" + i.shortValue());

        i = Int.valueOf(-1);
        System.out.println(i.intValue() + "/" + i.shortValue());

        i = Int.valueOf(-32768);
        System.out.println(i.intValue() + "/" + i.shortValue());

        i = Int.valueOf(-32769);
        System.out.println(i.intValue() + "/" + i.shortValue());

        i = Int.valueOf(57312);
        System.out.println(i.intValue() + "/" + i.shortValue());

        Int j = Int.valueOf(-97653);
        System.out.println(j.intValue() + "/" + j.shortValue());

        if (i.equals(j)) {
            System.out.println(i + " " + j + " is equal");
        } else {
            System.out.println(i + " " + j + " isn't equal");
        }

        j = Int.valueOf(57312);
        if (i.equals(j)) {
            System.out.println(i + " " + j + " is equal");
        } else {
            System.out.println(i + " " + j + " isn't equal");
        }
    }
}
