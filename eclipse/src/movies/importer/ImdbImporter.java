package movies.importer;
import java.util.*;
public class ImdbImporter extends Processor{
	public ImdbImporter(String sourceDir, String outputDir) {
		super(sourceDir, outputDir, true);
	}
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
