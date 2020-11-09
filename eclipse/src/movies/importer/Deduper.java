package movies.importer;
import java.util.*;
	
/**
* @author Juan-Carlos Sreng-Flores
* @author Nael-Louis
* A concrete class extending the abstract class Processor.
* It is implemented to remove any form of duplicates from a feed.
*/
public class Deduper extends Processor{
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * @author Nael-Louis
	 * Constructor class of Deduper which initializes its parameters by 
	 * calling the super class Processor.
	 * @param sourceDir String source directory of read file(s).
	 * @param outputDir String source directory of write file.
	 */
	public Deduper(String sourceDir, String outputDir) {
		super(sourceDir,outputDir, false);
	}
	
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * This method takes the input ArrayList<String> in order to look for duplicates
	 * within it.
	 * We use HashMap in order to speed up the process of finding its duplicate as we iterate 
	 * through the input ArrayList<String> making an approximately O(1) for finding the duplicate.
	 * The reason behind this is because with a hashFunction (coded in Movie.java), we can use it to
	 * retrieve an Object associated with a key (Movie type Object) in a runtime of O(1) depending on
	 * the load factor alpha. 
	 * Also, when the Movie's duplicate is found, it is merged into one movie, and replaced from the old
	 * value for the same key.
	 * Once the input ArrayList<String>'s iteration is finished, we convert the set of Values of the
	 * HashMap<Integer,Movie> into an ArrayList<String> making a final runtime of the method approx O(n).
	 * @param input ArrayList<String> containing all the lines movie data.
	 * @return ArrayList<String> returns the same list without duplicates.
	 */
	public ArrayList<String> process(ArrayList<String> input) {
		HashMap<Integer, Movie> noDupIntMovie = new HashMap<Integer, Movie>();
		for (String line : input) {
			//Using overloaded constructor to create a Movie type Object.
			Movie newMovie;
			Movie existingMovie;
			try {
				newMovie = new Movie(line);
			}
			catch(IllegalArgumentException i) {
				continue;
			}
			existingMovie = noDupIntMovie.get(newMovie.hashCode());
			if (existingMovie != null && existingMovie.equals(newMovie)) {
				existingMovie = existingMovie.mergeSimilarMovie(newMovie);
				noDupIntMovie.replace(newMovie.hashCode(), existingMovie);
			}
			else {
				noDupIntMovie.put(newMovie.hashCode(), newMovie);
			}
		}
		ArrayList<Movie> noDupMovie = new ArrayList<Movie>(noDupIntMovie.values());
		ArrayList<String> noDupString = new ArrayList<String>(noDupMovie.size());
		for (Movie movie : noDupMovie) {
			noDupString.add(movie.toString());
		}
		return noDupString;
	}
}
