package staticdemo;

public class ItemMain {
	
	public static void main(String[] args) {
		Item item1=new Item();
		Item item2=new Item();
		//
		//getCount() is a static method so it is a class member
		//so it is used from class
		//
		int count=Item.getCount();
		System.out.println("count="+count); 
	}

}
