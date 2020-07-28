package multithreaddemos;

public class RunnableExample {
	
	public static void main(String args[]) {
		Runnable thread1Runnable=new NumberRunnable("thread 1");
       Thread thread1=new Thread(thread1Runnable);
       thread1.start();
       
		Runnable thread2Runnable=new NumberRunnable("thread 2");
       Thread thread2=new Thread(thread2Runnable);
       thread2.start();	
       
		try {
			
		for (char ch = 'a'; ch < 'm'; ch++) {
			System.out.println("main class" + " char =" + ch);
			Thread.sleep(1000);
		}
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
       
       
       
       
	}

}
