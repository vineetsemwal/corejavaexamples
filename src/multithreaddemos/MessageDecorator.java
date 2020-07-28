package multithreaddemos;

public class MessageDecorator {

	/**
	 * expectation: (hello)
	 */
	 synchronized public void greet() {
		
		try {
			System.out.print("(");
			Thread.sleep(1000);
			System.out.print("hello");
			System.out.print(")");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
