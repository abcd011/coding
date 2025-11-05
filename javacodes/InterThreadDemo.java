class SharedResource {
    private int data;
    private boolean hasData = false;

    // Producer puts data
    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait(); // wait until data is consumed
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        data = value;
        System.out.println("Produced: " + data);
        hasData = true;
        notify(); // notify consumer
    }

    // Consumer gets data
    public synchronized void consume() {
        while (!hasData) {
            try {
                wait(); // wait until data is produced
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        System.out.println("Consumed: " + data);
        hasData = false;
        notify(); // notify producer
    }
}

public class InterThreadDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // Producer thread
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                resource.produce(i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                resource.consume();
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        });

        producer.start();
        consumer.start();
    }
}
