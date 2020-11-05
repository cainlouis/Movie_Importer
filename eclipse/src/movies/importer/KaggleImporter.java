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
	 * The index of the first string, which contains the name of each column, containing the Runtime, the title, and the year are 
	 * stored into a integer variable to create a new movie object.
	 * Then the toString method from the class Movie is used to add the movie object to the processed Arraylist which is then returned
	 * once all the string of input has been processed.  
	 */
	public ArrayList<String> process(ArrayList<String> input) {
		int columnNum = 0;
		int nameIndex = 0; 
		int runtimeIndex = 0; 
		int yearIndex = 0;
		ArrayList<String> processed = new ArrayList<String>();
		String[] separated = input.get(0).split("\\t");
		
		columnNum = separated.length;
		//Find the index of the column necessary to create a movie object
		for (int i = 0; i < columnNum; i++) {
			if (separated[i] == "Runtime") {
				runtimeIndex = i;
			}
			if (separated[i] == "Title") {
				nameIndex = i;
			}
			if (separated[i] == "Year") {
				yearIndex = i;
			}
		}
		
		//Create a movie object and add the string from toString() to the processed ArrayList 
		for (int i = 0; i < input.size(); i++) {
			separated = input.get(i).split("\\t");
			//if the amount of column is correct create the object
			if (separated.length == columnNum) {
				Movie newMovie = new Movie(separated[yearIndex], separated[nameIndex], separated[runtimeIndex], "kaggle");
				processed.add(newMovie.toString());
			}
		}
		return processed;
	}
	
	
}
