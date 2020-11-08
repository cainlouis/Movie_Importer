package movies.importer;
import java.io.*;
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * This class is the main class where it finds the file to be imported into the 
	 * be converted into a specific format.
	 */
public class ImportPipeline {
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * Creates many importers for the pipeline, and executes them all by calling
	 * the method processAll() which will execute all the importers in an orderly manner.
	 */
	public static void main(String[] args) throws IOException{
		String srcDirKaggleImporter= "..\\data\\KaggleSmallFile";
		String srcDirImdbImporter = "..\\data\\ImdbSmallFile";
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
		processAll(processor);
		
	}
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * @param importers - Processor[] where all the concrete classes that extends processor are put into it.
	 * This method will execute all the Processor Objects in order to complete the pipeline.
	 */
	public static void processAll(Processor[] importers) throws IOException{
		for(Processor importer : importers) {
			printStep(importer);
			importer.execute();
		}
	}
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
