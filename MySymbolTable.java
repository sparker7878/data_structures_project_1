import java.util.HashMap; //imports the HashMap from Java's API

/**************************************************************************
 * @author Sydney Parker
 * CS310 Spring 2018
 * Project 4
 * George Mason University
 *
 * File Name: MySymbolTable.java
 *
 * Description: Maintains the table for unique symbols (addresses) from a
 * sequence of references. Counts how many symbols are present in the table
 * (size), checks whether a symbol is present in the table (hasSymbol),
 * finds and returns the record we store in table for a symbol (getRecord),
 * sets the record for a symbol (putRecord), and removes the entry of a symbol
 * from the table (removeSymbol).
 *
 ***************************************************************************/

public class MySymbolTable<SymbolType, RecordType> implements SymbolTable<SymbolType, RecordType> {

	private HashMap<SymbolType, RecordType> map; //declares a new HashMap

	public MySymbolTable() {
		map = new HashMap<SymbolType, RecordType>(); //initializes the HashMap
	}

	/**
	 * Method which count how many symbols are present in table
	 * @return the integer count
	 *
	 */
	public int size() {
		return map.size();
	}

	/**
	 * Method which checks whether the symbol s is present in table
	 * @param s the symbol which is being looked up
	 * @return true if present, false otherwise
	 *
	 */
	public boolean hasSymbol(SymbolType s) {
		return map.containsKey(s);
	}

	/**
	 * Method which finds and returns the record we store in table for symbol s
	 * @param s the symbol which is being looked up
	 * @return the symbol, null if not present
	 *
	 */
	public RecordType getRecord(SymbolType s) {
		return map.get(s);
	}

	/**
	 * Method which sets the record of symbol s as r
	 * @param s the symbol which is being looked up
	 *
	 */
	public void putRecord(SymbolType s, RecordType r) {
			map.put(s,r);
	}

	/**
	 * Method which finds and removes the entry of symbol s from the table
	 * @param s the symbol which is being looked up
	 * @return the symbol which is removed, null if not present
	 *
	 */
	public RecordType removeSymbol(SymbolType s) {
		return map.remove(s);
	}

	public static void main(String[] args) {
		MySymbolTable<String,Integer> table = new MySymbolTable<String,Integer>();

		if (table.size()==0 && !table.hasSymbol("a")) {
			System.out.println("Yay 1");
		}

		table.putRecord("a",new Integer(136));
		table.putRecord("b",new Integer(112));

		if (table.size()==2 && table.hasSymbol("a") && table.getRecord("b").equals(new Integer(112))) {
			System.out.println("Yay 2");
		}

		table.putRecord("b",new Integer(211));
		Integer v = table.removeSymbol("a");
		if (table.size()==1 && v.equals(new Integer(136)) && !table.hasSymbol("a")
			&& table.getRecord("b").equals(new Integer(211))) 	{
			System.out.println("Yay 3");
		}
	}
}
