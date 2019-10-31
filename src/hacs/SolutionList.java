package hacs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * @author Sarvansh Prasher
 * @version 3.0
 * 
 *     
 */

public class SolutionList extends ArrayList<Solution> {

	private static final long serialVersionUID = 1L;

	List<Solution> solutions = new ArrayList<Solution>();

	public SolutionList() {

	}

	//// initialize the list by reading from the file.
	@SuppressWarnings("resource")
	public void initializeFromFile(String theFileName) {
		try {
			BufferedReader file;
			file = new BufferedReader(new FileReader("SolutionInfo.txt"));
			while ((file.readLine()) != null) {
				Solution theSolution;
				theSolution = new Solution();
				add(theSolution);
			}
		} catch (Exception ee) {
			;
		} finally {

		}
	}
	

	@SuppressWarnings("unchecked")
	@Override
    public Iterator<Solution> iterator() {
        return new SolutionIterator(this);
    }
}