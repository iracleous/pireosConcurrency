package gr.codehub.deadlockWithCallables;

import gr.codehub.callables.MyCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DeadLockExample {


    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();

        SyncThread thr1 = new SyncThread(o1, o2);
        SyncThread thr2 = new SyncThread( o2, o1);



        ExecutorService executor = Executors.newFixedThreadPool(10);



        List<Future<String>> list = new ArrayList<>();



            //submit Callable tasks to be executed by thread pool
            Future<String> future = executor.submit(thr1);
            list.add(future);
            future = executor.submit(thr2);
            list.add(future);
            //add Future to the list, we can get return value using Future



        for( Future<String> fut :list){
            try {
                System.out.println(fut.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();






    }


}
