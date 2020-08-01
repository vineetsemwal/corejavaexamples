package multithreaddemos;

public class DecoratorRunnable implements Runnable{

	private MessageDecorator decorator;
	
	public DecoratorRunnable(MessageDecorator adder) {
		this.decorator=adder;
	}
	
	@Override
	public void run() {
	  decorator.greet();	
	}
	

}
