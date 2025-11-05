class Counter {
    int count = 0;
    void increment() { count++; }
    synchronized void incrementSync() { count++; }
    int getCount() { return count; }
}

public class ThreadSync {
    public static void main(String[] args) throws InterruptedException {
        Counter c1 = new Counter();
        Thread t1 = new Thread(() -> { for(int i=0;i<10000;i++) c1.increment(); });
        Thread t2 = new Thread(() -> { for(int i=0;i<10000;i++) c1.increment(); });
        t1.start(); t2.start(); 
        t1.join(); t2.join();
        System.out.println("Without sync: " + c1.getCount());

        Counter c2 = new Counter();
        Thread t3 = new Thread(() -> { for(int i=0;i<10000;i++) c2.incrementSync(); });
        Thread t4 = new Thread(() -> { for(int i=0;i<10000;i++) c2.incrementSync(); });
        t3.start(); t4.start(); 
        t3.join(); t4.join();
        System.out.println("With sync: " + c2.getCount());

        Object l1 = new Object(), l2 = new Object();
        Thread d1 = new Thread(() -> { synchronized(l1) { try{Thread.sleep(50);}catch(Exception e){} synchronized(l2){} }});
        Thread d2 = new Thread(() -> { synchronized(l2) { try{Thread.sleep(50);}catch(Exception e){} synchronized(l1){} }});
        d1.start(); d2.start(); 
        d1.join(1000); d2.join(1000);
        System.out.println((d1.isAlive() || d2.isAlive()) ? "Deadlock detected" : "No deadlock");
    }
}
