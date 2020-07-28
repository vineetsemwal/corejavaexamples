package multithreaddemos;

public class SynchronizationExample {
	
	public static void main(String args[]) {
		MessageDecorator decorator=new MessageDecorator();
		Thread thread1=new Thread(new DecoratorRunnable(decorator));
		Thread thread2=new Thread(new DecoratorRunnable(decorator));
		Thread thread3=new Thread(new DecoratorRunnable(decorator));
		Thread thread4=new Thread(new DecoratorRunnable(decorator));
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
	}
	
}
