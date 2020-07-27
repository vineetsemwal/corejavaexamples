package generics;

import equalshash.Trainee;

public class StorageMain {
	
	public static void main(String[]args) {
		Trainee element=new Trainee(12,"pradeep");
		Storage<Trainee> storage=new Storage<>();
		storage.add(element);
		Trainee obj=storage.getElement();
		
	}

}
