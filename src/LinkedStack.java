package hw4;

/**
 * handles linked list using a stack interface
 * 
 * @author Alex
 *
 * @param <E>
 *            generic data type for the linked list
 */
public class LinkedStack<E> implements Stack<E> {
	private LinkedList<E> list = new LinkedList<>();

	/**
	 * default constructor
	 */
	public LinkedStack() {

	}

	/**
	 * returns size of the list
	 */
	@Override
	public int size() {
		return list.size();
	}

	/**
	 * checks if list is empty
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * adds the given node to the head of the list
	 */
	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	/**
	 * returns the head of the list
	 */
	@Override
	public E top() {
		return list.first();
	}

	/**
	 * removes the first value of the list
	 */
	@Override
	public E pop() {
		return list.removeFirst();
	}

}
