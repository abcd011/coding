
class MyThread extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("MyThread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("MyThread interrupted");
        }
    }
}

class MyRunnable implements Runnable {
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("MyRunnable: " + i);
                Thread.sleep(700);
            }
        } catch (InterruptedException e) {
            System.out.println("MyRunnable interrupted");
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        Thread t2 = new Thread(new MyRunnable());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread ends");
    }
}
