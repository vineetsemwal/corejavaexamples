package multithreaddemos;

public class SynchronizationExample {
	
	public static void main(String args[]) throws Exception {
		MessageDecorator decorator=new MessageDecorator();
		Thread thread1=new Thread(new DecoratorRunnable(decorator));
		Thread thread2=new Thread(new DecoratorRunnable(decorator));
		Thread thread3=new Thread(new DecoratorRunnable(decorator));
		Thread thread4=new Thread(new DecoratorRunnable(decorator));
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		boolean thread1Status=thread1.isAlive();
		boolean thread2Status=thread2.isAlive();
	    System.out.println("before join, thread1Status="+thread1Status+" thread2 status="+thread2Status);
		thread1.join();
		thread2.join();
	    thread1Status=thread1.isAlive();
	    thread2Status=thread2.isAlive();	   
	    System.out.println("\nafter join, thread1Status="+thread1Status+" thread2 status="+thread2Status);
		
		
	}
	
}
