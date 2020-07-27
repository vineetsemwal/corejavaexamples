package generics;

/**
 * 
 * store of one element
 * 
 * Fake T data type
 * Placeholder of real data type
 */
public class Storage<T> {
	  
	private T element;
	
	void add(T element) {
		this.element=element;
	}
	
	T getElement() {
		return element;
	}

}
