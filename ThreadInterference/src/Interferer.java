class Counter {
    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }
}

enum Operation {
    INCREASE, DECREASE;
}

class Operator implements Runnable {
    private Counter counter;
    Operation operation;
    int runTimes;
    int operationInterval;
    Operator(Counter counter, Operation operation, int runTimes, int operationInterval) {
        this.counter = counter;
        this.operation = operation;
        this.runTimes = runTimes;
        this.operationInterval = operationInterval;
    }

    public void run () {
        for (int i = 0; i < runTimes; i++) {
            switch (operation) {
                case INCREASE:
                    System.out.println("Before increment: " + counter.value());
                    counter.increment();
                    System.out.println("After increment: " + counter.value());
                    break;

                case DECREASE:
                    System.out.println("Before decrement: " + counter.value());
                    counter.decrement();
                    System.out.println("After decrement: " + counter.value());
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

public class Interferer {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread  increaser = new Thread(new Operator(counter, Operation.INCREASE, 1000, 100)),
                decreaser = new Thread(new Operator(counter, Operation.DECREASE, 1000, 100));
        increaser.start();
        decreaser.start();
        increaser.join();
        decreaser.join();

        System.out.println(counter.value());
    }
}
