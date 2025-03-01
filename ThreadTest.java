
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CountdownTimer extends Thread {
    private int seconds;
    private String message;

    public CountdownTimer(int seconds, String message) {
        this.seconds = seconds;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            for (int i = seconds; i >= 0; i--) {
                System.out.println(message + " - " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Countdown interrupted");
        }
    }
}

class SharedQueue {
    private final java.util.Queue<Integer> queue = new java.util.LinkedList<>();

    public synchronized void enqueue(int value) {
        queue.add(value);
        notify();
    }

    public synchronized int dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.poll();
    }
}

class NumberGenerator implements Runnable {
    private final SharedQueue queue;

    public NumberGenerator(SharedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int number = (int) (Math.random() * 100);
            System.out.println("Generated: " + number);
            queue.enqueue(number);
        }
    }
}

class NumberSumCalculator implements Runnable {
    private final SharedQueue queue;

    public NumberSumCalculator(SharedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int sum = 0;
        try {
            for (int i = 0; i < 10; i++) {
                sum += queue.dequeue();
            }
        } catch (InterruptedException e) {
            System.out.println("Sum calculation interrupted");
        }
        System.out.println("Total Sum: " + sum);
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        CountdownTimer timer = new CountdownTimer(5, "Counting down");
        timer.start();

        SharedQueue queue = new SharedQueue();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new NumberGenerator(queue));
        executor.execute(new NumberSumCalculator(queue));

        executor.shutdown();
    }
}


