package movies.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import movies.importer.Deduper;

class DeduperTests {
	//srcDir and outputDir for KAGGLE movie importer and Normalizer class.
	public static String c3P0SourceDir = "";
	public static String c3P0OutputDir ="";
	
	//srcDir and outputDir for IMDB movie importer and Validator class;
	public static String r2d2SourceDir = "";
	public static String r2d2OutputDir = "";
	/*******************TESTS FOR DEDUPER*****************************/
 	/**
 	 * @author Juan-Carlos Sreng-Flores
 	 * This test will use the HashSet<String> since the HashMap object will
 	 * not put give back the order given from the input ArrayList<String>
 	 * Therefore, since the hashCode is implemented, the HashSet<String> is used
 	 * in order to compare each other.
 	 */
 	@Test
 	void testDeduperProcess() {
 		Deduper deduper = new Deduper(r2d2SourceDir, r2d2OutputDir);
		ArrayList<String> input = new ArrayList<String>();
		HashSet<String> expected = new HashSet<String>();
		HashSet<String> validated;
		input.add("915\tNot Moana Again Please\t300\tkaggle;importer;imdb");
		input.add("2008\tthe mummy: tomb of the dragon emperor\t112\tbestImporterEver...");
		input.add("-10000\tAvengers\t180\tkaggle");		
		input.add("-10000\tAvengers\t180\tkaggle");	
		input.add("-10000\tAvengers\t180\tkaggle");	
		input.add("-10000\tAvengers\t180\tkaggle");	
		input.add("34\tmyTitle\t0\tkaggle");
		input.add("-10000\tAvengers\t180\tkaggle");
		input.add("1911\tDen sorte dr�m\t53\timdb");
		input.add("34\tmyTitle\t0\tOTHERSOURCE");
		input.add("2008\tthe mummy: tomb of the dragon emperor\t112\tkaggle;imdb");
		input.add("1911\tDen sorte dr�m\t53\tkaggle");
		input.add("2007\tthe mummy: tomb of the dragon emperor\t112\tkaggle;imdb");
		input.add("913\tNot Moana Again\t300\tkaggle;importer;imdb");
		input.add(null);
		validated = new HashSet<String>(deduper.process(input));
		expected.add("2008\tthe mummy: tomb of the dragon emperor\t112\tbestImporterEver...;kaggle;imdb");
		expected.add("-10000\tAvengers\t180\tkaggle");
		expected.add("1911\tDen sorte dr�m\t53\timdb;kaggle");
		expected.add("34\tmyTitle\t0\tkaggle;OTHERSOURCE");
		expected.add("2007\tthe mummy: tomb of the dragon emperor\t112\tkaggle;imdb");
		expected.add("915\tNot Moana Again Please\t300\tkaggle;importer;imdb");
		expected.add("913\tNot Moana Again\t300\tkaggle;importer;imdb");
		assertEquals(expected, validated);
 	}

}
