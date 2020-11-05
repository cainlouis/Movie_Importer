package movies.importer;

import java.util.ArrayList;

/**
 * A class that extends an abstract class to process an ArryList from a source directory
 * @author Nael Louis
 *
 */
public class KaggleImporter extends Processor {
	
	public KaggleImporter(String source, String destination) {
		super(source, destination, true);
	}
	
	/**
	 * Gets an ArrayList called input from a source directory and creates an ArrayList named processed that will contain 
	 * all of the Strings in input once processed. 
	 * To do so, the Strings are separated where there is a tab space and put into a String array. 
	 * Then the toString method from the class Movie is used to add the movie object to the processed Arraylist which is then returned
	 * once all the string of input has been processed.  
	 */
	public ArrayList<String> process(ArrayList<String> input) {
		ArrayList<String> processed = new ArrayList<String>();
		String[] separated = input.get(0).split("\\t");
		int columnNum = separated.length; 
		//Create a movie object and add the string from toString() to the processed ArrayList 
		for (String line : input) {
			separated = line.split("\\t");
			//if the amount of column is correct create the object
			if (separated.length == columnNum) {
				Movie newMovie = new Movie(separated[20], separated[15], separated[13], "kaggle");
				processed.add(newMovie.toString());
			}
		}
		return processed;
	}
	
	
}
