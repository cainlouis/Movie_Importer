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
	 * Constructor class of Deduper which initializes its parameters by 
	 * calling the super class Processor.
	 * @param sourceDir String source directory of read file(s).
	 * @param outputDir String source directory of write file.
	 */
	public Deduper(String sourceDir, String outputDir) {
		super(sourceDir,outputDir, false);
	}
	
	public ArrayList<String> process(ArrayList<String> input) {

		
		//this return statement is simply for compiling, it should be changed.
		return input;
	}
}
