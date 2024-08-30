import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> mpq = new PriorityQueue<>(new Comparator<>() {
            public int compare(Integer i, Integer j) {
                return Integer.compare(j, i);
            }
        });

        mpq.add(3);
        mpq.add(7);
        mpq.add(2);

        System.out.println(mpq.peek());
    }
}
