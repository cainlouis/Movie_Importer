package movies.importer;
import java.util.*;
public class Validator extends Processor{
	public Validator(String sourceDir, String outputDir) {
		super(sourceDir, outputDir, false);
	}
	
	public ArrayList<String> process(ArrayList<String> input) {
		String[] splitted;
		for (String line : input) {
			splitted = line.split("\\t",-1);
			
		}
		return input;
	}
}
