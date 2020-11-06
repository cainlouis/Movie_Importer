package movies.importer;
import java.util.*;
public class Deduper extends Processor{
	public Deduper(String sourceDir, String outputDir) {
		super(sourceDir,outputDir, false);
	}
	
	public ArrayList<String> process(ArrayList<String> input) {

		
		//this return statement is simply for compiling, it should be changed.
		return input;
	}
}
