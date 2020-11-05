package gr.codehub.concurrency;

public class Threading {

    public static void main(String[] args) {
        Balance balance = new Balance();

        Task task1 = new Task("thread 1", balance);
        Task task2 = new Task("thread 2", balance);


        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

//        task1.run();
//        task2.run();

        thread1.start();
        thread2.start();

        thread1.interrupt();


    }

}
