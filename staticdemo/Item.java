package staticdemo;

public class Item {

	//
	// count is static field which means it is member of class 
	// and not member of object
	//
	static int count;
	
	public Item() {
		count++;
	}

	public static int getCount() {
		return count;
	}


	
	
}
