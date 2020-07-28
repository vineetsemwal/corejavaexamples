package collectiondemos;

import java.util.*;

import equalshash.Trainee;

/**
 * 
 * 
 * Collection is a group of similar elements since list is a collection, it is
 * also a group of similar elements List inherits Collection and both are
 * interfaces
 * 
 * Features of List
 * 
 * 1) Indexed Collection
 * 
 * 2) Ordered Collection
 * 
 * 3) Elements can be duplicated
 * 
 * arraylist is good in performance fetching element by index arraylist is bad
 * in performance when elements are added or removed at start or middle
 *
 */
public class ListExample {

	public static void main(String[] args) {

		
		List<Trainee> list = new ArrayList<>();
		Trainee trainee1=new Trainee(10, "prakash");
		list.add(trainee1);// adding element at the end
		Trainee trainee2=new Trainee(11, "pradeep");
		list.add(trainee2);
		Trainee trainee4=new Trainee(13, "ankit");
		list.add(trainee4);
		Trainee trainee5=new Trainee(15, "pradeep");
		list.add(trainee5);
		Trainee trainee3=new Trainee(4, "anuj");
		list.add(trainee3);
		
         Comparator<Trainee> comparator=new TraineeComparator();
		list.sort(comparator);
		
		Trainee element2 = list.get(2);// fetching element at index 2
		int size = list.size();

		System.out.println("size before removing element=" + size);

		list.remove(1);// removing element at index 1
		
		list.remove(trainee2);// removing by passing element

		size = list.size();// size of list

		// list.clear();// clearing list

		System.out.println("size after removing element=" + size);

		boolean iscontain = list.contains("anuj");
		System.out.println("contains=" + iscontain);

		for (int i = 0; i < list.size(); i++) {
			Trainee trainee = list.get(i);
			System.out.println("element=" + trainee.getId() + " " + trainee.getName());

		}

		System.out.println("*****using for each******");
		for (Trainee trainee : list) {
			System.out.println("element=" + trainee.getId() + " " + trainee.getName());
		}
		
		System.out.println("******using iterator*******");
	   Iterator<Trainee> iterator=list.iterator();
	   //hasNext() will return true if next element is available
	   while(iterator.hasNext()) {		 
			Trainee trainee = iterator.next();// fetch next element
			System.out.println("element=" + trainee.getId() + " " + trainee.getName());
		  
	   }
	   
	}

}
