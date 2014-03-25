import java.util.Collection;

/**
 * This interface implements a Dynamic Array object 
 * 
 * @author Surya Bhamidipati
 */
public class MyDynamicArray<T> implements DynamicArrayInterface<T> {
	
	private T[] bag;
	private static final int LENGTH = 10;
	private int numberOfArrays;
	
	@SuppressWarnings("unchecked")
	public MyDynamicArray() {
		bag = (T[]) new Object[LENGTH];
		numberOfArrays = 0;
	}
	
	/**
	 * Returns whether array is full or not.
	 * 
	 * @return whether the bag is full or not.
	 */
	private boolean isFull() {
		return numberOfArrays == bag.length;
	}
	
	/**
	 * Resizes the array by creating a new backing array  double the length of the old one and copying
	 * all elements to the new array.
	 */
	private void resizeArray() {
		@SuppressWarnings("unchecked")
		T[] newBag = (T[]) new Object[bag.length * 2];
		for (int i = 0; i < bag.length; i++) {
			newBag[i] = bag[i];
		}
		bag = newBag;
	}
	
	@Override
	public void add(T toAdd) {
		if (isFull()) {
			resizeArray();
		}
		bag[numberOfArrays++] = toAdd;
	}

	@Override
	public void addAll(Collection<T> collection) {
		@SuppressWarnings("unchecked")
		T[] toBag = (T[]) collection.toArray();
		for (T data: toBag) {
			add(data);
		}
	}
	
	/**
	 * Gets index of the object in backing array equal to the object being compared
	 * 
	 * @param object to be found
	 * @return index of the object equal to the one compared.
	 */
	private int getIndex(T obj) {
		for (int index = 0; index < numberOfArrays; index++) {
			if (bag[index].equals(obj)) {
				return index;
			}
		}
		return -1;
	}

	@Override
	public T remove(T toRemove) {
		return remove(getIndex(toRemove));
	}

	@Override
	public T remove(int index) {
		if (index < numberOfArrays && index >= 0) {
			T result = bag[index];
			for (int i = index + 1; i < numberOfArrays; i++) {
				bag[i - 1] = bag[i];
			}
			numberOfArrays--;
			return result;
		} else {
			return null;
		}
	}

	@Override
	public T get(int index) {
		if (index < numberOfArrays && index >= 0) {
			return bag[index];
		} else {
			return null;
		}
	}

	@Override
	public boolean contains(T obj) {
		return getIndex(obj) != -1; 
	}
	
	@Override
	public T[] toArray() {
		return bag;
	}

	@Override
	public boolean isEmpty() {
		return numberOfArrays == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		bag = (T[]) new Object[LENGTH];
		numberOfArrays = 0;
	}

	@Override
	public int size() {
		return numberOfArrays;
	}

}
