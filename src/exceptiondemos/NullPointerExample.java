package exceptiondemos;

public class NullPointerExample {

	public static void main(String[] args) {
		NullPointerExample demo = new NullPointerExample();
		Product product = null;
		demo.display(product);
		System.out.println("bye bye");
	}

	public void display(Product product) {
		//
		// exception occured on the below line when program was getting executed
		// exception caused the progam to exit
	//	try {
			String id = product.getId();
			String name = product.getName();
			System.out.println("product =" + id + " " + name);
		//} catch (NullPointerException e) {
	//		System.out.println("exception occured, product is null");
		//}

		System.out.println("inside display method, after  product info");
	}

}
