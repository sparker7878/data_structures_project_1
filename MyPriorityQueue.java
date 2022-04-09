/**************************************************************************
 * @author Sydney Parker
 * CS310 Spring 2018
 * Project 4
 * George Mason University
 *
 * File Name: MyPriorityQueue.java
 *
 * Description: Maintains a max priority queue where priority of a parent node
 * is higher than the priority of its children. Counts the number of items
 * (size), to return the max item (peek), removes the max item (remove), inserts
 * an item with its corresponding priority in to the queue (insert), checks
 * whether there exists an item with a priority (contains), and updates the
 * priority of an item (updatePriority).
 *
 ***************************************************************************/

public class MyPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

	static final int INF = Integer.MAX_VALUE; //the max priority to use: infinity
	private Pair<T>[] array; //declares a generic helper array
	private int size; //declares a size variable

	private class Pair<T extends Comparable<T>> { //holds two values as one entity
		private T item; //declares an item
		private int priority; //declares the item's priority

		public Pair(T item, int priority) {
			this.item = item; //sets item
			this.priority = priority; //sets priority
		}

		/**
		 * Method which implements compareTo() by comparing
		 * @return the integer count
		 *
		 */
		private int compareTo(T differentItem) {
			return item.compareTo(differentItem);
		}
	}

	@SuppressWarnings("unchecked")
  public MyPriorityQueue() {
		array = new Pair[6]; //initializes the underlying array
		size = 0; //initializes size as 0
  }

	/**
	 * Method which count how many items present in priority queue
	 * @return the integer count
	 *
	 */
	public int size() {
		return size;
	}

	/**
	 * Method which returns the top item (of the max priority)
	 * @return top item, null if empty
	 *
	 */
	public T peek() {
		if (size == 0) {
			return null;
		}
		return array[1].item;
	}

	/**
	 * Method which removes the top item (of the max priority)
	 * @return item to be deleted, null if empty
	 *
	 */
	public T remove() {
		size--;
		return null;
	}

	/**
	 * Method which inserts an item v of priority p
	 * @param v the item to be inserted
	 * @param p the priority of the item
	 *
	 */
	public void insert(T v, int p) {
		size++;
	}

	/**
	 * Method which perform a priority update for items in the priority queue
	 * @param v the item to have its priority updated
	 * @param p the priority of the item
	 *
	 */
	public void updatePriority(T v, int p) {
		int num = 0;
	}

	/**
	 * Method which checks whether there is a value v associated with priority p
	 * @param v the item to be checked
	 * @param p the priority of the item to be checked
	 * @return true if present, false otherwise
	 *
	 */
	public boolean contains(T v, int p) {
		return false;
	}

	public static void main(String[] args) {
		MyPriorityQueue<String> pq = new MyPriorityQueue<String>();

		if (pq.size()==0 && pq.remove()==null && !pq.contains("a", 4)) {
			System.out.println("Yay 1");
		}

		pq.insert("a",4);
		pq.insert("b",10);
		pq.insert("h",2);

		if (pq.size()==3 && (pq.peek()).equals("b") && pq.contains("a",4) && pq.contains("h",2)
			&& pq.contains("b",10)) {
			System.out.println("Yay 2");
		}

		if ((pq.remove()).equals("b") && !pq.contains("b",10) & pq.size()==2
			&& (pq.peek().equals("a"))) {
			System.out.println("Yay 3");
		}

		pq.insert("d",4);
		if ((pq.peek()).equals("d")) {
			System.out.println("Yay 4");
		}

		pq.insert("b",10);
		pq.insert("f",3);
		pq.updatePriority("a",3);
		if (pq.size() == 5 && pq.contains("a",3) && pq.contains("b",10) && pq.contains("d",4)
			&& pq.contains("f",2) && pq.contains("h",1)) {
			System.out.println("Yay 5");
		}
	}
}
