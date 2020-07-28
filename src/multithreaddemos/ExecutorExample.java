package multithreaddemos;

import java.util.concurrent.*;

public class ExecutorExample {


    /**
     *  Managing thread xxx
      *  business operation
     *   +
     *   Thread pool---pool of threads
     *
     *
     *
     *   3 tasks , 2 threads
     */
    public static void main(String[]args){
       ExecutorService executorService =Executors.newFixedThreadPool(2);
       Runnable task1=new NumberRunnable("task 1");
       Runnable task2=new NumberRunnable("task 2");
       Runnable task3=new NumberRunnable("task 3");
       executorService.submit(task1);
       executorService.submit(task2);
       executorService.submit(task3);



        executorService.shutdown();

    }


	
}
