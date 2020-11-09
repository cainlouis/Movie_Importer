package movies.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import movies.importer.Validator;

/** 
 * @author Juan-Carlos Sreng-Flores
 * JUnit test class to test the Validator Class process method
 */
class ValidatorTests {
	//srcDir and outputDir for KAGGLE movie importer and Normalizer class.
	public static String c3P0SourceDir = "";
	public static String c3P0OutputDir ="";
	
	//srcDir and outputDir for IMDB movie importer and Validator class;
	public static String r2d2SourceDir = "";
	public static String r2d2OutputDir = "";
	/*******************TESTS FOR VALIDATOR**************************/
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * This test inserts in the process method the input ArrayList<String>
	 * containing valid movie format and invalid possible movie formats.
	 * The test calls the process method and assertsEquals what is expected, and what 
	 * is validated by the process method from Validator class.
	 */
 	@Test
	void testValidatorProcess() {
		Validator validator = new Validator(r2d2SourceDir, r2d2OutputDir);
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<String> expected = new ArrayList<String>();
		ArrayList<String> validated;
		//should not be valid lines
		input.add(null);
		input.add("year\ttitle\tduration\timdb");
		input.add("\tsampleTitle\t\timdb");
		input.add("");
		input.add("");
		input.add(null);
		input.add("\n\n\t\t");
		input.add("-10000\tAvegers\t180 \tkaggle");
		//should  be valid lines
		input.add("-0\tmyTitle\t0\tkaggle");
		input.add("-10000\tAvengers\t180\tkaggle");
		input.add("1911\tDen sorte dr�m\t53\timdb");
		validated = validator.process(input);
		expected.add("-0\tmyTitle\t0\tkaggle");
		expected.add("-10000\tAvengers\t180\tkaggle");
		expected.add("1911\tDen sorte dr�m\t53\timdb");
		assertEquals(expected, validated);
	}

}

