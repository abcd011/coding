class SharedResource {
    private int data;
    private boolean hasData = false;


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
        notifyAll();
    }

    public synchronized void consume(){
        while(!hasData){
            try{
                wait();
            } catch(InterruptedException e){
                e.getMessage();
            }
        }
        System.out.println("Consumed: " + data);
        hasData = false;
        notifyAll();
    }

}

public class ThreadInterCommunication{
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                resource.produce(i);
                try { 
                    Thread.sleep(300); 
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                resource.consume();
                try { 
                    Thread.sleep(500); 
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }
        });
        

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Program finished");
    }

}
