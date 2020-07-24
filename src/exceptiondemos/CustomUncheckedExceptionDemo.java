package exceptiondemos;

public class CustomUncheckedExceptionDemo {

	public static void main(String[] args) {

		CustomUncheckedExceptionDemo demo = new CustomUncheckedExceptionDemo();
		Product product = null;
		demo.display(product);
		System.out.println("bye bye");

	}

	public void display(Product product) {
		if (product == null) {
				InvalidArgUncheckException exception = new InvalidArgUncheckException("invalid argument");
				throw exception;
				//compiler not forcing us to handle exception 
		}
		String id = product.getId();
		String name = product.getName();
		System.out.println("product =" + id + " " + name);

	}

}
