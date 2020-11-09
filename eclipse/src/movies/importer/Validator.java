package movies.importer;
import java.util.*;
import movies.utilities.*;

/**
 * @author Juan-Carlos Sreng-Flores
 * The Validaor class extends the Processor class.
 * It takes the feed from the ImbdImporter class, or the KaggleImporter class.
 * After taking these feeds, it runs through the data, and validates the movies 
 * whether they have the minimum requirements to be considered as movies or not.
 * It then creates a new file, containing the movies that are valid. 
 */
public class Validator extends Processor{
	/**
	 * Constructor method, calls superClass for initialization and the file read does not 
	 * contain a header.
	 * @param sourceDir String the source directory for file reading.
	 * @param outputDir String the output directory for file writing.
	 */
	public Validator(String sourceDir, String outputDir) {
		super(sourceDir, outputDir, false);
	}
	
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * This method goes through the ArrayList<String> input and 
	 * selects whether if the elements are valid Movie formats.
	 * 
	 * @param input ArrayList<String> containing the lines of the data file
	 * @return ArrayList<String> returning the valid elements only.*/
	public ArrayList<String> process(ArrayList<String> input) {
		ArrayList<String> validMovies = new ArrayList<String>();
		for (String line : input) {	 
			//helper method call to check validity of String line. 
			if(isValidMovie(line)) {
			 	validMovies.add(line);
			 }
		}
		return validMovies;
	}
	/** 
	 * @author Juan-Carlos Sreng-Flores
	 * This is a helper method in order to make the reading experience more enjoyable.
	 * This method checks whether the inputs given in the String line are valid inputs.
	 * If the line does not contain the right amount of \t to create a Movie it returns false.
	 * If the names are null or "", the method returns false.
	 * If the releaseYear or the runtime is NaN, it also returns false.
	 * If everything is acceptable according the conditions, it returns true;
	 * @param line a String containing the information to create a Movie.
	 * @return boolean the validity of the Movie Object
	 * */
	private static boolean isValidMovie(String line) {
		boolean valid = false;
		if((line!=null)) {
			String[] splitter = line.split("\\t",-1);
			/* If the String does not have enough \t characters to create a movie, the method returns false. 
			 * We check the length so that when creating a Movie object, we do not get a IndexOutOfBoundException.
			 */
			if(splitter.length>=4) {
				/* Creates new movie object instance since it is easier to access attributes
				 * instead of tracking down indexes in debugging purposes.
				 */
				//Using the split method, and making sure there are 4 elements in array, we are ensure that the inputs are non-null values.
				Movie movie = new Movie(splitter[0],splitter[1],splitter[2],splitter[3]);
				//Checks whether name or source attributes are not null or empty strings (i.e "").
				valid = !movie.getName().equals("");
				valid = valid && !(movie.getSource() == null || movie.getSource().equals(""));
				/* This method uses the isNumber(String) from Utilities class to see if it is
				 * a number or not. If it is not, then valid will be put to false because of && operand. 
				 */
				valid = valid && Utilities.isNumber(movie.getReleaseYear());
				valid = valid && Utilities.isNumber(movie.getRuntime());
				/**
				 * We include 0 in this case because it could be 5 seconds for example.
				 * If valid is false, the Integer.parseInt() method will not throw an Exception since the && operand
				 * stops it from doing it.
				 * If valid is true, then from the isNumber() method, we are safe to parse the runtime attribute.
				 */
				valid = valid && Integer.parseInt(movie.getRuntime()) >= 0;
			 }
		}
		return valid;
	}
	
}
