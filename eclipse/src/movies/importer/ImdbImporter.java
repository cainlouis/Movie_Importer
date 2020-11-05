package movies.importer;
import java.util.*;
	/**
	 *  @author Juan-Carlos Sreng-Flores
	 *  A class that extends Processor.java. It performs pipeline of file data.
	 *  */
public class ImdbImporter extends Processor{
	/**
	 * Constructor method, calls super class to initialize attributes.
	 * 
	 * @param sourceDir a String used to get the source of the textfile importer.
	 * @param outputDir a String used to output the newly textfile processed.
	 * */
	public ImdbImporter(String sourceDir, String outputDir) {
		super(sourceDir, outputDir, true);
	}
	
	/**
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
		String[] splitted;
		for (String line: input) {
			splitted = line.split("\\t",-1);
			Movie movie = new Movie(splitted[3], splitted[1], splitted[6],"imdb");
			transform.add(movie.toString());
		}
		return transform;
	}
}
