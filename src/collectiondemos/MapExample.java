package collectiondemos;

import java.util.*;

import equalshash.Trainee;

public class MapExample {

	public static void main(String[] args) {
		Trainee trainee1 = new Trainee(10, "prakash");
		Trainee trainee2 = new Trainee(11, "pradeep");
		Trainee trainee3 = new Trainee(4, "anuj");
		Trainee trainee4 = new Trainee(13, "ankit");
		Trainee trainee5 = new Trainee(15, "pradeep");

		Map map = new HashMap();
		map.put(10, trainee1);
		map.put(11, trainee2);
		map.put(4, trainee3);
		map.put(13, trainee4);
		map.put(15, trainee5);
		
		int size=map.size();
		
		System.out.println("size="+size);

		Object fetched = map.get(11);// fetching value associated with key 11
		Trainee trainee = (Trainee) fetched;
		System.out.println(trainee.getId() + " " + trainee.getName());

		map.remove(4);// removing element by key=4
		
		Set keys = map.keySet();
		for (Object k : keys) {
			Object v = map.get(k);
			Trainee traineeObj = (Trainee) v;
			System.out.println(traineeObj.getId() + " " + traineeObj.getName());

		}

	}

}
