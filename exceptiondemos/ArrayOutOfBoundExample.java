package exceptiondemos;

public class ArrayOutOfBoundExample {

	public static void main(String args[]) {
		try {
		int numbers[]= {1,2,3};
		int element =numbers[5];
	    System.out.println(element);
		}
		catch(Exception e) {
			System.out.println("exception caught");
		    e.printStackTrace();
		 }
		System.out.println("bye bye");
	}
}
