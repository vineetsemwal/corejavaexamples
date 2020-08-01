package multithreaddemos;

import java.util.concurrent.*;

public class ExecutorCallable {
	
	public static void main(String args[]) throws Exception{
		ExecutorService service=Executors.newCachedThreadPool();
		Callable<Integer> task1=new SumCallable();
		Future<Integer>futureResult =service.submit(task1);
		System.out.println("is result available="+futureResult.isDone());
        int result= futureResult.get(); //blocking method  
    	System.out.println("is result available after get method="+futureResult.isDone());
        System.out.println("result="+result);         
        service.shutdown();
	}

}
