package collectiondemos;

import java.util.Comparator;

import equalshash.Trainee;

public class TraineeComparator implements Comparator<Trainee>{

	@Override
	public int compare(Trainee o1, Trainee o2) {
		int id1=o1.getId();
		int id2=o2.getId();
		int compare=id1-id2;
		return compare;
	}

	
}
