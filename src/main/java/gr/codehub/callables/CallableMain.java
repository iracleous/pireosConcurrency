package gr.codehub.callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableMain {

    public static void main(String[] args) {

        ExecutorService executor1 = Executors.newFixedThreadPool(10);
        ExecutorService executor2 = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<>();
        Callable<String> callable = new MyCallable();

        for(int i=0; i< 100; i++){
            //submit Callable tasks to be executed by thread pool
            Future<String> future = executor1.submit(callable);
            list.add(future);
            future = executor2.submit(callable);
            list.add(future);
            //add Future to the list, we can get return value using Future

        }

        for( Future<String> future :list){
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor1.shutdown();
        executor2.shutdown();

    }
}
