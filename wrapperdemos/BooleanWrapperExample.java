package wrapperdemos;

public class BooleanWrapperExample {

	public static void main(String[]args) {		
		boolean bool=false;// primitive
		Boolean boolWrapper=new Boolean(true);//wrapper
		boolean primitiveBoolean=boolWrapper.booleanValue();
		String boolString=boolWrapper.toString();
		System.out.println("wrapper="+boolWrapper);
		System.out.println("primitive="+primitiveBoolean);
		System.out.println("string="+boolString);
	}
	
}
