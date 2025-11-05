class MyRunnable implements Runnable{
    public void run(){
        try {
            System.out.println("Thread runnable is running");
            for(int i = 0; i < 15; i++){
                System.err.println(i);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread runnable Inturrupted");
        }
    }
}
class Mythread extends Thread{
    public void run(){
        System.out.println("Thread extends is running");
        try {
            for(int i = 0; i < 15; i++){
                System.err.println(i);
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread extends Inturrupted");
        }
    }
}

public class ThreadDemo{
    public static void main(String[] args) {
        MyRunnable obj = new MyRunnable();
        Thread t1 = new Thread(obj);

        Thread t2 = new Mythread();

        t1.start();
        t2.start();
         try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}