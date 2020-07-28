package multithreaddemos;

public class ThreadExample1 {

	public static void main(String args[]) {
		Thread1 thread1=new Thread1("thread 1");
		thread1.start();
		try {
		
		for (int i = 0; i < 10; i++) {
			System.out.println("main class" + " i=" + i);
			Thread.sleep(1000);
		}
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
