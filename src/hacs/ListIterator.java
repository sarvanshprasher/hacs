package hacs;

import java.util.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * @author Sarvansh Prasher
 * @version 3.0
 */

public class ListIterator implements Iterator<Object> {

	ArrayList<Object> list;
	int currentNumber = -1;

	public ListIterator() {}

	/*
	 * 
	 * This function creates a constructor where array list will be passed
	 */
	public ListIterator(ArrayList<Object> arrayList) {

		list = arrayList;

	}

	/*
	 * 
	 * This function check if there is next element in the list
	 */
	public boolean hasNext() {

		if (currentNumber >= list.size() - 1)
			return false;
		else
			return true;

	}

	/*
	 * 
	 * This function gets the object of next element from the list
	 */
	public Object next() {

		if (hasNext() == true) {
			currentNumber++;
			return list.get(currentNumber);
		} else {
			return null;
		}

	}

	/*
	 * 
	 * This function removes the element from the list
	 */
	public void remove() {

		list.remove(currentNumber);

	}
}