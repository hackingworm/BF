public class driver {
    public static void main(String[] args) {
        Object key1 = new Object();
        Object key2 = new Object();

        Thread t8 = new Thread(() -> {
            synchronized (key1) {
                System.out.println("t8 has key 1");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (key2) {
                    System.out.println("t8 has key 2");
                }
            }
        });

        Thread t9 = new Thread(() -> {
            /* synchronized (key2) {
                System.out.println("t9 has key 2");
                synchronized (key1) {
                    System.out.println("t9 has key1");
                }
            }

            In original codes, t8, t9 both need to acquire key1, key2,
            however, they get these critical resources in reverse order,
            which leads to deadlock. so, The solution is rather
            straightforward, just let them get the resources in same order.
             */

            synchronized (/* key2 */ key1) {
                System.out.println("t9 has key 1");
                synchronized (/* key1 */ key2) {
                    System.out.println("t9 has key2");
                }
            }

        });

        t8.start();
        t9.start();
    }
}
