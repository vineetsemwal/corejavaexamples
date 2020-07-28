package multithreaddemos;

public class ThreadExample1 {

	public static void main(String args[]) {
		NumberThread thread1=new NumberThread("thread 1");
		thread1.start();
		
		NumberThread thread2=new NumberThread("thread 2");
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
