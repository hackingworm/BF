class SingletonCounter {
    private int c = 0;

    public synchronized void increment () {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }

    private static SingletonCounter onlyInstance;

    private SingletonCounter() {
        c = 0;
    }

    public synchronized static SingletonCounter SingletonCounter() {
        if (null == onlyInstance) {
            onlyInstance = new SingletonCounter();
        }

        return onlyInstance;
    }
}

enum Operation {
    INCREASE, DECREASE;
}

class Operator implements Runnable {
    private SingletonCounter counter;
    Operation operation;
    int runTimes;
    int operationInterval;
    Operator(Operation operation, int runTimes, int operationInterval) {
        counter = SingletonCounter.SingletonCounter();
        this.operation = operation;
        this.runTimes = runTimes;
        this.operationInterval = operationInterval;
    }

    public void run () {
        System.out.println("Counter's hashcode: " + counter.hashCode());

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

public class SingletonTest {
    public static void main(String[] args) throws InterruptedException {
        Thread  increaser = new Thread(new Operator(Operation.INCREASE, 10, 100)),
                decreaser = new Thread(new Operator(Operation.DECREASE, 10, 100));
        increaser.start();
        decreaser.start();
        increaser.join();
        decreaser.join();

        SingletonCounter counter = SingletonCounter.SingletonCounter();
        System.out.println("Counter's hashcode: " + counter.hashCode() + ", value: " + counter.value());
    }
}