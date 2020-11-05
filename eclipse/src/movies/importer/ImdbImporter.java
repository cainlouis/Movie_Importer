package movies.importer;
import java.util.*;
public class ImdbImporter extends Processor{
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * Constructor method, calls super class to initialize attributes.
	 * 
	 * @param sourceDir a String used to get the source of the textfile importer.
	 * @param outputDir a String used to output the newly textfile processed.
	 * */
	public ImdbImporter(String sourceDir, String outputDir) {
		super(sourceDir, outputDir, true);
	}
	
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * The method takes in as a input an ArrayList<String> and processes
	 * all the entries within it. 
	 * it converts the String into a Movie.toString() format.
	 * 
	 * @param input ArrayList<String> containing the lines to process.
	 * @return ArrayList<String> a list of the new processed entries.
	 * */
	@Override
	public ArrayList<String> process(ArrayList<String> input) {
		ArrayList<String> transform = new ArrayList<String>();
		for (String line: input) {
			String[] splitted = line.split("\\t",-1);
			Movie movie = new Movie(splitted[3], splitted[2], splitted[6],"imdb");
			transform.add(movie.toString());
		}
		return transform;
	}
}
