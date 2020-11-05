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
			 if(isValidMovie(line)) {
			 	validMovies.add(line);
			 }
		}
		return validMovies;
	}
	/** 
	 * @author Juan-Carlos Sreng-Flores
	 * This is a helper method. It is set inside the Validator class because
	 * It respects the purpose of Validating data for the Pipeline, which also respects the 
	 * entity of the Object Validator. 
	 * This method checks whether the inputs given in the String line are valid inputs.
	 * If the line does not contain the right amount of \t to create a Movie it returns false.
	 * If the names are null or "", the method returns false.
	 * If the releaseYear or the runtime is NaN, it also returns false.
	 * If everything is acceptable according the conditions, it returns true;
	 * @param line a String containing the information to create a Movie.
	 * @return boolean the validity of the Movie Object*/
	public static boolean isValidMovie(String line) {
		boolean valid = false;
		if(!(line==null || line.equals(""))) {
			String[] splitter = line.split("\\t",-1);
			 if(splitter.length>=4) {
				Movie movie = new Movie(splitter[0],splitter[1],splitter[2],splitter[3]);
				valid = !(movie.getName() == null || movie.getName().equals(""));
				valid = valid && !(movie.getSource() == null || movie.getSource().equals(""));
				
				try {
					Integer.parseInt(movie.getReleaseYear());
					Integer.parseInt(movie.getRuntime());
				}
				catch (NumberFormatException n) {
					valid = false;
				}
			 }
		}
		System.out.println(valid);
		return valid;
	}
	
}
