package hw4;

/**
 * handles linked lists
 * 
 * @author Alex
 *
 * @param <E>
 *            generic data type
 */
public class LinkedList<E> {
	private static class Node<E> {
		private E element;
		private Node<E> next;

		/**
		 * constructs a node with given element and sets the next element
		 * 
		 * @param e
		 *            element
		 * @param n
		 *            next element
		 */
		public Node(E e, Node<E> n) {
			this.element = e;
			this.next = n;
		}

		/**
		 * gets element
		 * 
		 * @return element
		 */
		public E getElement() {
			return element;
		}

		/**
		 * gets element next to current element
		 * 
		 * @return next element
		 */
		public Node<E> getNext() {
			return next;
		}

		/**
		 * sets the next element
		 * 
		 * @param n
		 *            element
		 */
		public void setNext(Node<E> n) {
			this.next = n;
		}
	}

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	/**
	 * default constructor
	 */
	public LinkedList() {

	}

	/**
	 * returns the size of the list
	 * 
	 * @return size of list
	 */
	public int size() {
		return size;
	}

	/**
	 * checks if the list is empty
	 * 
	 * @return if the list empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * returns first node of the list
	 * 
	 * @return first node of list
	 */
	public E first() {
		if (isEmpty()) {
			return null;
		} else {
			return head.getElement();
		}
	}

	/**
	 * returns last node of the list
	 * 
	 * @return last node of list
	 */
	public E last() {
		if (isEmpty()) {
			return null;
		} else {
			return tail.getElement();
		}
	}

	/**
	 * adds node to front of list
	 * 
	 * @param e
	 *            node to be added
	 */
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (isEmpty()) {
			tail = head;
		}
		size++;
	}

	/**
	 * adds node to end of list
	 * 
	 * @param e
	 *            node to be added
	 */
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty()) {
			head = newest;
		} else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}

	/**
	 * removes the node at front of the list
	 * 
	 * @return returns the first node fo the list
	 */
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (isEmpty()) {
			tail = null;
		}
		return answer;
	}
}