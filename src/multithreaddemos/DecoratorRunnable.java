package multithreaddemos;

public class DecoratorRunnable implements Runnable{

	private MessageDecorator adder;
	
	public DecoratorRunnable(MessageDecorator adder) {
		this.adder=adder;
	}
	
	@Override
	public void run() {
	  adder.greet();	
	}
	

}
