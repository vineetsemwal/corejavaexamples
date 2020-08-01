package stringdemos;

public class StringExample {

	public static void main(String args[]) {
		
		// strings are immutable ie. string object are constants that cant be changed
		
		String str1="hyderabad";//string pool
	    
		char ch=str1.charAt(4);
		
		String str2=str1.concat("city");
	 
		System.out.println("char at index 4="+ch);
		
		System.out.println("str1="+str1);
		
		System.out.println("str2="+str2);
		
		String substring1=str1.substring(4);
		System.out.println("substring1="+substring1);
		
		String substring2=str1.substring(4,6);
		System.out.println("substring2="+substring2);
		
		int indexOf=str1.indexOf("ra");
		System.out.println("ra found at index="+indexOf);
		
		String changedObject=str1.replace("ra", "rey");
	    System.out.println("changed object="+changedObject);
	}
	
}
