package collectiondemos;

import java.util.Comparator;

public class IdComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		int compared=o1-o2;
		return compared;
	}

}
