package movies.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import movies.importer.Normalizer;

/**
 * @author Nael Louis
 * JUnit test class to test the Normalizer process method
 */
class NormalizerTests {
	//srcDir and outputDir for KAGGLE movie importer and Normalizer class.
	public static String c3P0SourceDir = "";
	public static String c3P0OutputDir ="";
	
	//srcDir and outputDir for IMDB movie importer and Validator class;
	public static String r2d2SourceDir = "";
	public static String r2d2OutputDir = "";
	/**
	 * @author Nael Louis
	 * This method tests the process() method of the normalizer class
	 * Two ArrayList<String> are hardcoded, one, testList, as an input to process() and the other as the expected result 
	 * to the process() method. 
	 */
	@Test 
	void testNormalizer() {
		ArrayList<String> testList = new ArrayList<>();
		testList.add("Year\tTitle\tRuntime\tkaggle");
		testList.add("2008\tThe Mummy: Tomb of the Dragon Emperor\t112 minutes\tkaggle");
		Normalizer test = new Normalizer(c3P0SourceDir, c3P0OutputDir);
		ArrayList<String> processed = test.process(testList);
		ArrayList<String> expected = new ArrayList<>();
		expected.add("Year\ttitle\tRuntime\tkaggle");
		expected.add("2008\tthe mummy: tomb of the dragon emperor\t112\tkaggle");
		assertEquals(expected, processed);
	}
}

