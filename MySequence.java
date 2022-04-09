import java.util.TreeSet; //imports the TreeSet from Java's API

/**************************************************************************
 * @author Sydney Parker
 * CS310 Spring 2018
 * Project 4
 * George Mason University
 *
 * File Name: MySequence.java
 *
 * Description: Stores a collection of values as a sorted sequence with no
 * duplicates. Supports inserting a new value in to the collection (insert),
 * removing a value from the collection (remove), finding if a value is present
 * in the collection (contains), finding how many values are present in the
 * collection (size), and finding a string representation of all values in
 * collection in ascending order (toStringAscendingOrder). Also supports the
 * method (countNoSmallerThan) to count the values in the collection that are
 * greater than or equals to a specific value.
 *
 ***************************************************************************/

public class MySequence<T extends Comparable<T>> implements Sequence<T> {

	private TreeSet<T> tree; //declares a new TreeSet

	public MySequence() {
		tree = new TreeSet<T>(); //initializes the TreeSet
	}

	/**
	 * Method which count how many symbols are present in table
	 * @return the integer count
	 *
	 */
	public int size() {
		return tree.size();
	}

	/**
	 * Method which adds a new value v into the collection
	 * @param v the new value to be added into the collection
	 * @return true if added successfully, false otherwise
	 *
	 */
	public boolean insert(T v) {
		return tree.add(v);
	}

	/**
	 * Method which deletes value v from the collection
	 * @param v the value to be removed from the collection
	 * @return true if removed successfully, false otherwise
	 *
	 */
	public boolean remove(T v) {
		return tree.remove(v);
	}

	/**
	 * Method which finds whether value v is present in collection
	 * @param v the value to be searched for
	 * @return true if value is present, false otherwise
	 *
	 */
	public boolean contains(T v) {
		return tree.contains(v);
	}

	/**
	 * Method which counts how many values are greater than or equal to v
	 * @param v the new value to be removed from the collection
	 * @return the integer count
	 *
	 */
	public int countNoSmallerThan(T v) {
		int count = 0; //counter variable

		for (T item : tree) { //goes through each item in tree
			if (item.compareTo(v) >= v.compareTo(item)) { //compares it to v
				count++;
			}
		}
		return count;
	}

	/**
	 * Method which returns a string representation of values in ascending order
	 * @param v the new value to be removed from the collection
	 * @return string representation of collection's values
	 *
	 */
	public String toStringAscendingOrder() {
		String ascend = ""; //empty string

		for (T num : tree) { //traverses the tree
			ascend += num + " "; //takes each number and appends it to the string
		}

		return ascend;
	}

	public static void main(String[] args) {
		MySequence<Integer> seq = new MySequence<Integer>();

		if (seq.size()==0) {
			System.out.println("Yay 0.1");
		}

		if (seq.size()==0 && !seq.contains(11) && seq.countNoSmallerThan(10) == 0
			&& seq.toStringAscendingOrder().equals("")) {
			System.out.println("Yay 1");
		}

		seq.insert(11);
		seq.insert(5);

		if (seq.insert(200) && seq.size()==3 && seq.contains(11)
			&& seq.countNoSmallerThan(10) == 2 && !seq.remove(20)) {
			System.out.println("Yay 2");
		}

		seq.insert(112);
		seq.insert(50);
		seq.insert(20);

		if (seq.remove(20) && !seq.contains(20) && !seq.insert(200)
			&& seq.countNoSmallerThan(50) == 3
			&& seq.toStringAscendingOrder().equals("5 11 50 112 200 ")) {
			System.out.println("Yay 3");
		}
	}
}
