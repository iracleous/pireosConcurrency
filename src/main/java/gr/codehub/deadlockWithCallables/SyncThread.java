package gr.codehub.deadlockWithCallables;

import java.util.concurrent.Callable;
public class SyncThread implements Callable<String> {
    private Object obj1;
    private Object obj2;

    public SyncThread(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public String call() throws Exception{
        String name = Thread.currentThread().getName();
        System.out.println(name + " acquiring lock on " + obj1);
        synchronized (obj1) {
            System.out.println(name + " acquired lock on " + obj1);
            work();
            System.out.println(name + " acquiring lock on " + obj2);
            synchronized (obj2) {
                System.out.println(name + " acquired lock on " + obj2);
                work();
            }
            System.out.println(name + " released lock on "+obj2);
         }
        System.out.println(name + " released lock on "+obj1);
        System.out.println(name + " finished execution.");
        return name + " finished execution.";
    }


    private void  work(){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}



