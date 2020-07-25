package collectiondemos;

import java.util.*;

/**
 * 
 * 
 Collection is a group of similar elements
 since list is a collection, it is also a group of similar elements
 List inherits Collection and both are interfaces  
  
 Features of List
  
1) Indexed Collection

2) Ordered Collection

3) Elements can be duplicated

 *
 */
public class ListExample {
	
	public static void main(String[]args) {
     List list=new ArrayList();	
	 list.add("prakash");
	 list.add("pradeep");
	 list.add("anuj");
	 list.add("ankit");
	 list.add("pradeep");
	 
	 Object element2=list.get(2);
	 String element2String=(String)element2;
	 int size=list.size();
		 
	 System.out.println("size before removing element="+size);
	 
	 list.remove(1);
	 
	 size=list.size();
	
	 //list.clear();
	 
	 System.out.println("size after removing element="+size);
	 
	 for(int i=0;i<list.size();i++) {
		Object obj =list.get(i);
		String str=(String)obj; 
		System.out.println("element="+str); 
	 
	 }
	 
	 System.out.println("using for each");
	 for(Object obj:list) {
		String str=(String)obj; 
		System.out.println("element="+str); 
	 }
	 
	 
	 
	}
	
}
