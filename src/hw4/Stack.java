package hw4;

/**
 * collection of objects that can be added or removed according to last in first
 * out principle
 * 
 * @author Alex
 *
 * @param <E>
 *            generic data type
 */
public interface Stack<E> {

	/**
	 * returns number of elements in the stack
	 * 
	 * @return number of elements in stack
	 */
	int size();

	/**
	 * checks if stack is empty
	 * 
	 * @return if the stack is empty
	 */
	boolean isEmpty();

	/**
	 * adds element to top of the stack
	 * 
	 * @param e
	 *            element to be added
	 */
	void push(E e);

	/**
	 * returns the element at the top of the stack
	 * 
	 * @return element at top of stack
	 */
	E top();

	/**
	 * removes and returns the element at the top of the stack
	 * 
	 * @return element removed
	 */
	E pop();
}
