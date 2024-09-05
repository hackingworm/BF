import java.util.concurrent.atomic.AtomicInteger;

enum Operation {
    INCREASE, DECREASE;
}

class Operator implements Runnable {
    AtomicInteger counter;
    Operation operation;
    int runTimes;
    int operationInterval;
    Operator(AtomicInteger counter, Operation operation, int runTimes, int operationInterval) {
        this.counter = counter;
        this.operation = operation;
        this.runTimes = runTimes;
        this.operationInterval = operationInterval;
    }

    public void run () {
        for (int i = 0; i < runTimes; i++) {
            switch (operation) {
                case INCREASE:
                    System.out.println("Before increment: " + counter.getAndIncrement());
                    System.out.println("After increment: " + counter.get());
                    break;

                case DECREASE:
                    System.out.println("Before decrement: " + counter.getAndDecrement());
                    System.out.println("After decrement: " + counter.get());
                    break;

                default:
                    break;
            }

            if (0 < operationInterval) {
                try {
                    Thread.sleep(operationInterval);
                } catch (InterruptedException ie) {
                    System.out.println(ie);
                }
            }
        }
    }
}

public class AtomicCounter {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();
        Thread  increaser = new Thread(new Operator(counter, Operation.INCREASE, 1000, 100)),
                decreaser = new Thread(new Operator(counter, Operation.DECREASE, 1000, 100));
        increaser.start();
        decreaser.start();
        increaser.join();
        decreaser.join();

        System.out.println(counter.get());
    }
}
