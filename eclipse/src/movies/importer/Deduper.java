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
	 * @author Nael-Louis 
	 * This process method iterates creates an ArrayList<Movie> in order to 
	 * take benefit of the equals overridden method of the Movie class.
	 * It converts all the String lines into a Movie object, and inserts it into the 
	 * ArrayList<Movie>. ArryaList<Movie> is used to look for duplicates as we add more elements.
	 * If it finds it, the movie Object is merged with the existing element, if not it is added at the end
	 * of the list.
	 * @param input ArrayList<String> containing all the lines movie data.
	 * @return ArrayList<String> returns the same list without duplicates.
	 */
	public ArrayList<String> process(ArrayList<String> input) {
		ArrayList<Movie> noDup = new ArrayList<Movie>();
		for (String line : input) {
			//Using overloaded constructor to create a Movie type Object.
			Movie movie;
			try {
				movie = new Movie(line);
			}
			catch(IllegalArgumentException i) {
				continue;
			}
			int index = noDup.indexOf(movie);
			if (index==-1) {
				noDup.add(movie);
			}
			else {
				movie = movie.mergeSimilarMovie(noDup.get(index));
				noDup.add(index, movie);
			}
		}
		ArrayList<String> noDupString = new ArrayList<String>();
		for (Movie movie : noDup) {
			noDupString.add(movie.toString());
		}
		return noDupString;
	}
	public ArrayList<String> process1(ArrayList<String> input) {
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
			if (existingMovie != null) {
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
