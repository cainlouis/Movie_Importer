package movies.importer;

import java.util.ArrayList;

/**
 * A class that extends an abstract class to process an ArryList from a source directory
 * @author Nael Louis
 *
 */
public class Normalizer extends Processor {
	
	/**
	 * A parameterized constructor calls a super class to initialize its attributes.
	 * @param source a string that contains the source of the textfile importer.
	 * @param destination a string that contains the destination of the processed textfile.
	 */
	public Normalizer(String source, String destination) {
		super(source, destination, false);
	}
	
	/**
	 * Gets an ArrayList called input from a source directory and creates an ArrayList named processed that will contain 
	 * all of the Strings in input once processed. 
	 * To do so, the string is split into an array then the String that contains the title is changed into lower case
	 * and the String that contains the runtime is split again and only the first word is added to the movie.
	 * @return ArrayList<String> a list containing all the processed line.
	 */
	public ArrayList<String> process(ArrayList<String> input) {
		ArrayList<String> processed = new ArrayList<>();
		
		for (String line : input) {
			if(line != null) {
				String[] inputArr = line.split("\\t",-1);
				//Make sure that program doesn't throw IndexOutOfBoundException.
				if (inputArr.length >= 4) {
					//Create a movie object to get the name and runtime
					Movie newMovie = new Movie(inputArr[0], inputArr[1], inputArr[2], inputArr[3]);
					//Change the name into lower case and split the runtime string to get the first word
					inputArr[1] = inputArr[1].toLowerCase();
					String[] runtimeArr = newMovie.getRuntime().split("\\s");
					inputArr[2] = runtimeArr[0];
					//Recreate the movie object to get the new String
					Movie toList = new Movie(inputArr[0], inputArr[1], inputArr[2], inputArr[3]);
					processed.add(toList.toString());
				}
			}
		}
		return processed;
	}
}
