package stringdemos;

public class StringBuilderExample {

	public static void main(String []args) {
		StringBuilder builder=new StringBuilder();
		builder.append("hyderabad").append("delhi").append("mumbai");
	    String str= builder.toString();
		System.out.println(str);
				
		
	}
	
}
