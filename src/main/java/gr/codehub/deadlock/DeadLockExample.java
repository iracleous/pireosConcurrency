package gr.codehub.deadlock;

public class DeadLockExample {


    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();

        SyncThread thr1 = new SyncThread(o1, o2);
        SyncThread thr2 = new SyncThread( o2, o1);

        new Thread(thr1).start();
       // Thread.sleep(5000);
        new Thread(thr2).start();

    }


}
