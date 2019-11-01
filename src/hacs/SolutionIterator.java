package hacs;

import java.util.Iterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sarvansh Prasher
 * @version 2.0
 */

@SuppressWarnings("rawtypes")
public class SolutionIterator implements Iterator {
	SolutionList solutionlist;

	/// CurrentSolutionNumber: point to the location before the first element
	int currentSolutionNumber = -1;

	public SolutionIterator() {
	}

	public SolutionIterator(SolutionList thesolutionlist) {

		solutionlist = thesolutionlist;
		MoveToHead();

	}

	/*
	 * This function points to head of the solution
	 */
	public void MoveToHead() {

		currentSolutionNumber = -1;

	}

	/*
	 * This function check if there is next Solution.
	 */
	public boolean hasNext() {

		if (currentSolutionNumber >= solutionlist.size() - 1)
			return false;
		else
			return true;

	}

	/*
	 * This function get the Object next Solution.
	 */
	public Object next() {

		if (hasNext() == true) {
			currentSolutionNumber++;
			return solutionlist.get(currentSolutionNumber);
		} else {
			return null;
		}

	}

	/*
	 * This function get the next Solution that fits the Username;
	 */
	public Object next(String userName) {

		Solution solution;
		solution = (Solution) next();
		while (solution != null) {
			if (userName.compareTo(solution.author) == 0) {
				return solution;
			}
			solution = (Solution) next();
		}
		return null;

	}

	/*
	 * This function removes the current solution from solution list
	 */
	public void remove() {

		solutionlist.remove(currentSolutionNumber);

	}

}