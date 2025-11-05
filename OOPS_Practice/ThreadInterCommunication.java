class SharedResource {
    private int data;
    private boolean hasData = false;

    public class MyRunnable implements Runnable{
        public void run(){
            System.out.println("Thread" + Thread.currentThread().getName() + "is runnning");
        }
    }

    public synchronized void produce(int val){
        while(hasData){
            try{
                wait();
            } catch(InterruptedException e){
                e.getMessage();
            }
        }
        data = val;
        System.out.println("Produced: " + data);
        hasData = true;
        notify();
    }

    public synchronized void consume(int val){
        while(!hasData){
            try{
                wait();
            } catch(InterruptedException e){
                e.getMessage();
            }
        }
        System.out.println("Consumed: " + data);
        hasData = false;
        notify();
    }

}

public class ThreadInterCommunication{
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                resource.produce(i);
                try { Thread.sleep(500); } catch (InterruptedException e) {};
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                resource.consume(i);
                try { Thread.sleep(500); } catch (InterruptedException e) {};
            }
        });
        

        producer.start();
        consumer.start();
    }

}
