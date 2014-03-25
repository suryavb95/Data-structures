
public class LinkedList<T> implements LinkedListInterface<T>{

	private Node firstNode;
	private Node Lastnode;
	private int numberOfEntries;
	
	@Override
	public void addToFront(T t) {
		Node newNode = new Node(t);
		
		if (isEmpty()) {
			firstNode = newNode;
			lastNode = newNode;
		}
		
		else {
			newNode.setNextNode(firstNode);
			frstNode = newNode;
		}
	}

	@Override
	public void addToBack(T t) {
		Node newNode = new Node(t);
		
		if (isEmpty())
			firstNode = newNode;
		else 
			lastNode.setNextNode(newNode);
		lastNode = newNode;
		numberOfEntries++;	
	}

	@Override
	public T removeFromFront() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeFromBack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] toList() {
		@SupressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		
		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries)) && (currentNode != null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		}
		
		return result;
	}

	@Override
	public boolean isEmpty() {
		boolean result;
		if(numberOfEntries == 0) {
			assert firstNode == null;
			result = true;
		}
		
		else {
			assert firstNode != null;
			result = false;
		}
		
		return result;
	}

	@Override
	public int size() {
		return numberOfEntries;
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;	
	}

	/**
	 * The node class. Remember that this is a singularly linked list.
	 * 
	 * @author Steven Wojcio
	 */
	private class Node<T>{
		//TODO Auto-generated method stub
	}

}
