package movies.importer;

import java.util.ArrayList;

/**
 * A class that extends an abstract class to process an ArryList from a source directory
 * @author Nael Louis
 *
 */
public class KaggleImporter extends Processor {
	
	/**
	 * A parameterized constructor that calls a super class to initialize its attributes.
	 * @param source a string that contains the source of the textfile importer.
	 * @param destination a string that contains the destination of the processed textfile.
	 */
	public KaggleImporter(String source, String destination) {
		super(source, destination, true);
	}
	
	/**
	 * Gets an ArrayList called input from a source directory and creates an ArrayList named processed that will contain 
	 * all of the Strings in input once processed. 
	 * To do so, the Strings are separated where there is a tab space and put into a String array. 
	 * Then the toString method from the class Movie is used to add the movie object to the processed Arraylist.
	 * @return ArrayList<String> a list of all the processed string.  
	 */
	public ArrayList<String> process(ArrayList<String> input) {
		ArrayList<String> processed = new ArrayList<String>();
		String[] separated;
		//Create a movie object and add the string from toString() to the processed ArrayList 
		for (String line : input) {
			if(line != null) {
				separated = line.split("\\t",-1);
				//if the amount of column is correct create the object
				if (separated.length >= 21) {
					Movie newMovie = new Movie(separated[20], separated[15], separated[13], "kaggle");
					processed.add(newMovie.toString());
				}
			}
		}
		return processed;
	}
	
	
}
