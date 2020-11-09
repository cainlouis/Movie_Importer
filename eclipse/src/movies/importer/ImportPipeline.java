package movies.importer;
import java.io.*;
	
/**
* @author Juan-Carlos Sreng-Flores
* @author Nael Louis
* This class is the main class where it finds the file to be imported into the 
 * be converted into a specific format.
*/
public class ImportPipeline {
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * @author Nael Louis
	 * Creates many importers for the pipeline, and executes them all by calling
	 * the method processAll() which will execute all the importers in an orderly manner.
	 */
	public static void main(String[] args) throws IOException{
		String srcDirKaggleImporter= "..\\data\\KaggleLargeFile";
		String srcDirImdbImporter = "..\\data\\ImdbLargeFile";
		String srcDirNormalizer = "..\\data\\Normalizer";
		String srcDirValidator = "..\\data\\Validator";
		String srcDirDeduper = "..\\data\\Deduper";
		String outputDirFinal = "..\\data\\FinalOutput";
		//create Processor[] and call processAll();
		Processor[] processor = new Processor[5];
		processor[0] = new KaggleImporter(srcDirKaggleImporter, srcDirNormalizer);
		processor[1] = new ImdbImporter(srcDirImdbImporter, srcDirNormalizer);
		processor[2] = new Normalizer(srcDirNormalizer, srcDirValidator);
		processor[3] = new Validator(srcDirValidator, srcDirDeduper);
		processor[4] = new Deduper(srcDirDeduper,outputDirFinal);
		
		//processAllLargeFiles(processor);  //Use this method to processLargeFiles, and to print the time it took to process.
		processAll(processor);
	}
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * @param importers - Processor[] where all the concrete classes that extends processor are put into it.
	 * This method will execute all the Processor Objects in order to complete the pipeline.
	 */
	public static void processAll(Processor[] importers) throws IOException{
		for(Processor importer : importers) {
			importer.execute();
			printStep(importer);
		}
		long endTime = System.nanoTime();
	}
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * @param importers - Processor[] where all the concrete classes that extends processor are put into it.
	 * This method will execute all the Processor Objects in order to complete the pipeline.
	 * The use of System.nanoTime is to calculate how much time it takes to execute the program.
	 * It is recommended to use it in large files so it gives the step of the progress.
	 */
	private static void processAllLargeFiles(Processor[] importers) throws IOException{
		long startTime = System.nanoTime();
		for(Processor importer : importers) {
			importer.execute();
			printStep(importer);
		}
		long endTime = System.nanoTime();
		long duration = ((endTime - startTime)/1000000);  //divide by 1000000 to get milliseconds.
		System.out.println("Finished in "+duration+" miliseconds");
	}
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * Gives you step by step processing so we can keep track of the progress.
	 * @param processor - Processor. We use it to know what kind of object it is.
	*/
	private static void printStep(Processor processor) {
		if(processor instanceof KaggleImporter) {
			System.out.println("KaggleImporter execute.");
		}
		else if(processor instanceof ImdbImporter) {
			System.out.println("ImdbImporter execute.");
		}
		else if(processor instanceof Normalizer) {
			System.out.println("Normalizer execute.");
		}
		else if(processor instanceof Validator) {
			System.out.println("Validator execute.");
		}
		else {
			System.out.println("Deduper execute.");
		}
	}
}
