package gr.codehub.concurrency;
import java.lang.Runnable;

public class Task implements  Runnable{

    private String threadName;
    private Balance balance;

    public Task(String threadName, Balance balance) {
        this.threadName = threadName;
        this.balance = balance;
    }

    @Override
    public void run() {


        for (int i=0;i<10;i++) {
            System.out.println(threadName + " i= " + i);
            if (Thread.interrupted()) {
                //actions to close connections
                // and return
                return;
            }
            Thread.yield();

            try {
                Thread.sleep(100);
                synchronized(balance) {
                    balance.setBalance(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }



    }
}
