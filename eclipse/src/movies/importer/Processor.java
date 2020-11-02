package movies.importer;

import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.*;

/**
 * An abstract class that is implemented to execute one step of an import pipeline.
 * @author Daniel Pomerantz
 *
 */
public abstract class Processor {
	// A local directory representing where to search for .txt files
	private String srcDir;
	
	// A local directory representing where to put the .txt files produced. This folder must exist before the program starts.
	private String outputDir;
	
	// true if the processor should automatically remove the first line of every file.
	private boolean srcContainsHeader;
	
	public Processor(String sourceDir, String outputDir, boolean srcContainsHeader) {
		this.srcDir = sourceDir;
		this.outputDir = outputDir;
		this.srcContainsHeader = srcContainsHeader;
	}
	
	/**
	 * loadData is a method that takes all the files located in the source directory
	 * It then merges all the lines together into a single list before calling
	 * The abstract process method.
	 * Whatever is returned by the abstract process method is then saved to the single file
	 * outputDir
	 * After this, the original input files are renamed to append ".processed" to them
	 */
	public void execute() throws IOException{
		File folder = new File(this.srcDir);
		File[] fromFiles = folder.listFiles();
		
		// All the lines of the file before processing
		ArrayList<String> beforeProcessing = new ArrayList<String>();

		for (File file : fromFiles) {
			if (file.getAbsolutePath().endsWith(".txt")) {
				Path pathToFile = Paths.get(file.getAbsolutePath());
				List<String> lines = Files.readAllLines(pathToFile);
				
				if (this.srcContainsHeader) {
					lines.remove(0);
				}
				
				beforeProcessing.addAll(lines);
			}
		}
		
		// Now do the work in the concrete classes
		List<String> afterProcessing = this.process(beforeProcessing);
		Files.write(Paths.get(this.outputDir, "result_" + this.getClass().getSimpleName() + ".txt"), afterProcessing);
		
		// after doing the processing, rename the files to mark they are completed
		for (File file : fromFiles) {
			if (file.getAbsolutePath().endsWith(".txt")) {
				file.renameTo(new File(file.getAbsoluteFile() + ".processed"));
			}
		}		
	}
	
	/** abstract method that is required to be provided in any concrete class that
	 * extends the abstract Processor class
	 * @param input An ArrayList<String> representing the input to the processor
	 * @return Returns an ArrayList<String> representing the results of applying this processor
	 */
	public abstract ArrayList<String> process(ArrayList<String> input);
		
}
