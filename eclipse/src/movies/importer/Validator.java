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
	
	public ArrayList<String> process(ArrayList<String> input) {
		String[] splitted;
		Movie movie;
		ArrayList<String> validMovies = new ArrayList<String>();
		for (String line : input) {
			splitted = line.split("\\t",-1);
			movie = new Movie(splitted[0],splitted[1],splitted[2],splitted[3]);
			if (isValidMovie(movie)) {
				validMovies.add(line);
			}
		}
		return input;
	}
	public static boolean isValidMovie(Movie movie) {
		boolean valid;
		valid = !((movie.getName() == null)||movie.getName() == "");
		valid = valid && Utilities.isNumber(movie.getReleaseYear());
		valid = valid && Utilities.isNumber(movie.getRuntime());
		return valid;
	}
}
