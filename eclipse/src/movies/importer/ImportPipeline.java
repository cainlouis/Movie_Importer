package movies.importer;
import java.io.*;
public class ImportPipeline {
	public static void main() {
		String srcDirKaggleImporter= "";
		String srcDirImdbImporter = "";
		String srcDirNormalizer = "";
		String srcDirValidator = "";
		String srcDirDeduper = "";
		String outputDirFinal = "";
		//create Processor[] and call processAll(); 
	}
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * @param importers - Processor[] where all the concrete classes that extends processor are put into it.
	 * This method will execute all the Processor Objects in order to complete the pipeline.
	 */
	public static void processAll(Processor[] importers) throws IOException{
		for(Processor importer : importers) {
			importer.execute();
		}
	}
}
