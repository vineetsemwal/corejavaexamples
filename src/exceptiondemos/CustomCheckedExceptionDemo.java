package exceptiondemos;

public class CustomCheckedExceptionDemo {

	public static void main(String[] args) throws InvalidArgumentCheckedException{

		CustomCheckedExceptionDemo demo = new CustomCheckedExceptionDemo();
		Product product = null;
		demo.display(product);
		System.out.println("bye bye");

	}

	public void display(Product product) throws InvalidArgumentCheckedException{
		if (product == null) {
				InvalidArgumentCheckedException exception = new InvalidArgumentCheckedException("invalid argument");
				throw exception;			
		}
		
		String id = product.getId();
		String name = product.getName();
		System.out.println("product =" + id + " " + name);

	}

}
