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
		
	}
	public static void processAll(Processor[] importers) throws IOException{
		for(Processor importer : importers) {
			importer.execute();
		}
	}
}
