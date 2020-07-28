package multithreaddemos;

public class Thread1 extends Thread {

	public Thread1(String name) {
		super(name);
	}

	@Override
	public void run() {
		// super.run();
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(getName() + " i=" + i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
           e.printStackTrace(); 
		}
	}

}
