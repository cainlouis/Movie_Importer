package movies.tests;
import movies.importer.*;
import movies.utilities.*;
import java.io.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MovieTests {
	//srcDir and outputDir for KAGGLE movie importer and Normalizer class.
	public static String c3P0SourceDir = "";
	public static String c3P0OutputDir ="";
	
	//srcDir and outputDir for IMDB movie importer and Validator class;
	public static String r2d2SourceDir = "";
	public static String r2d2OutputDir = "";
	/******************TESTS FOR MOVIE CLASS******************/
	
	/** @author Juan-Carlos Sreng-Flores
	 * 	@author Nael Louis
	 * This method tests the getter Method for the releaseYear attribute*/
	@Test
	void testMovieGetReleaseYear() {
		Movie movie = new Movie("2016", "Moana", "Any runtime", "imdb");
		assertEquals("2016", movie.getReleaseYear());
	}
	
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * @author Nael Louis
	 * This method tests the getter method for the name attribute.*/
	@Test
	void testMovieGetName() {
		Movie movie = new Movie("2016", "Moana", "Any runtime", "kaggle");
		assertEquals("Moana", movie.getName());
	}
	
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * @author Nael Louis
	 * This method tests the getter method for the runtime attribute.*/
	@Test
	void testMovieGetRuntime() {
		Movie movie = new Movie("2016", "Moana", "Any runtime", "imdb");
		assertEquals("Any runtime", movie.getRuntime());
	}
	
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * @author Nael Louis
	 * This method tests the getter method for the source attribute.*/
	@Test
	void testMovieGetSource() {
		Movie movie = new Movie("2016", "Moana", "Any runtime", "imdb");
		assertEquals("imdb", movie.getSource());
	}
	
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * @author Nael Louis
	 * This method tests the overridden toString() method in the Movie class.
	 * The toString method is expected to return a string similar to the following:
	 * 	"releaseYear\tname\truntime\tsource"
	 * 
	 * */
	@Test 
	void testMovieToString() {
		Movie movie = new Movie("2016", "Moana", "Any runtime", "kaggle");
		assertEquals("2016\tMoana\tAny runtime\tkaggle", movie.toString());
	}
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * This method tests the overriden equals method from the Object class
	 * in the Movie class.
	 * We call the equals method on both Movie object to make sure no mistake
	 * escapes these tests.
	 */
	@Test
	void testMovieEquals() {
		//Some sample tests ...
		//Should fail the test since releaseYear is not a number.
		Movie test1 = new Movie("","","","");
		Movie test2 = new Movie("","","","");
		assertEquals(false, test1.equals(test2));
		assertEquals(false, test2.equals(test1));
		//Should fail the test since runtime is not a number.
		test1 = new Movie("2016", "Moana", "Any runtime", "kaggle");
		test2 = new Movie("2016", "Moana", "Any runtime", "kaggle");
		assertEquals(false, test1.equals(test2));
		assertEquals(false, test2.equals(test1));
		//Test for releaseYear.
		//Should pass the test.
		test1 = new Movie("2016", "Moana", "60", "imdb");
		test2 = new Movie("2016", "Moana", "60", "imdb");
		assertEquals(true, test1.equals(test2));
		assertEquals(true, test2.equals(test1));
		//Should fail the test since year is different.
		test1 = new Movie("5106", "Moana", "60", "imdb");
		test2 = new Movie("2016", "Moana", "60", "imdb");
		assertEquals(false, test1.equals(test2));
		assertEquals(false, test2.equals(test1));
		//Test name of Movie
		//Should fail the test since name is not exactly the same.
		test1 = new Movie("2016", "Moanaa", "60", "imdb");
		test2 = new Movie("2016", "Moana", "60", "imdb");
		assertEquals(false, test1.equals(test2));
		assertEquals(false, test2.equals(test1));
		//Should fail the test since lowercase should already be implemented and name is not exactly the same.
		test1 = new Movie("2016", "moana", "60", "imdb");
		test2 = new Movie("2016", "Moana", "60", "imdb");
		assertEquals(false, test1.equals(test2));
		assertEquals(false, test2.equals(test1));
		//Should pass the test since the names are exactly the same.
		test1 = new Movie("913", "Not Moana Again", "300", "kaggle");
		test2 = new Movie("913", "Not Moana Again", "300", "kaggle");
		assertEquals(true, test1.equals(test2));
		assertEquals(true, test2.equals(test1));
		//Test runtime of Movie
		//Should fail the test since runtime not a number.
		test1 = new Movie("2020", "Avengers", "e60", "imdb");
		test2 = new Movie("2020", "Avengers", "60", "imdb");
		assertEquals(false, test1.equals(test2));
		assertEquals(false, test2.equals(test1));
		//Should pass the test
		//Should pass the test since runtime are equal.
		test1 = new Movie("2020", "DrillBit", "60", "imdb");
		test2 = new Movie("2020", "DrillBit", "60", "imdb");
		assertEquals(true, test1.equals(test2));
		assertEquals(true, test2.equals(test1));
		//Should pass the test since they are within 5 minutes between each other.
		test1 = new Movie("2020", "DrillBit", "65", "imdb");
		test2 = new Movie("2020", "DrillBit", "60", "imdb");
		assertEquals(true, test1.equals(test2));
		assertEquals(true, test2.equals(test1));
		test1 = new Movie("2020", "DrillBit", "64", "imdb");
		test2 = new Movie("2020", "DrillBit", "60", "imdb");
		assertEquals(true, test1.equals(test2));
		assertEquals(true, test2.equals(test1));
		test1 = new Movie("2020", "DrillBit", "12", "imdb");
		test2 = new Movie("2020", "DrillBit", "18", "imdb");
		assertEquals(false, test1.equals(test2));
		assertEquals(false, test2.equals(test1));
		//Should fail the test since they are not within 5 minutes between each other.
		test1 = new Movie("2020", "DrillBit", "65", "imdb");
		test2 = new Movie("2020", "DrillBit", "59", "imdb");
		assertEquals(false, test1.equals(test2));
		assertEquals(false, test2.equals(test1));
		//Test source of Movie.
		//Should pass the test since the equals does not take into consideration the source to determine equality.
		test1 = new Movie("2020", "DrillBit", "1", "imdb");
		test2 = new Movie("2020", "DrillBit", "1", "kaggle");
		assertEquals(true, test1.equals(test2));
		assertEquals(true, test2.equals(test1));
		
	}
	/**
	 * This test method tests the correctness of the mergeSimilarMovie in the Movie's class.
	 * Two Movie Objects are created from hardcoded initialization values, then tested on the correctness
	 * of the method mergeSimilarMovie. 
	 * The method similarMovie is supposed to return null if the movies are not similar. On the other hand,
	 * if they are similar (i.e test1.equals(test2)==true), the mergeSimilarMovie method returns a movie Object.
	 */
	@Test
	void testMovieMergeSimilarMovie() {
		//Should be false since the runtime and releaseYear are not numbers.
		Movie test1 = new Movie("","","","");
		Movie test2 = new Movie("","","","");
		Movie merged = test1.mergeSimilarMovie(test2);
		assertEquals("", merged!=null?merged.toString():"");
		merged = test2.mergeSimilarMovie(test1);
		//Should pass the test since 
		test1 = new Movie("2020", "DrillBit", "1", "imdb");
		test2 = new Movie("2020", "DrillBit", "1", "kaggle");
		merged = test1.mergeSimilarMovie(test2);
		assertEquals("2020\tDrillBit\t1\timdb;kaggle", merged!=null?merged.toString():"");
		merged = test2.mergeSimilarMovie(test1);
		assertEquals("2020\tDrillBit\t1\tkaggle;imdb", merged!=null?merged.toString():"");
		//Should pass the following test
		test1 = new Movie("2020", "", "1", "imdb");
		test2 = new Movie("2020", "", "5", "kaggle");
		merged = test2.mergeSimilarMovie(test1);
		merged = merged.mergeSimilarMovie(test1);
		assertEquals("2020\t\t5\tkaggle;imdb;imdb", merged!=null?merged.toString():"");
		//Should fail the test
		test1 = new Movie("2020", "MyTest", "-1", "IMDBIMPORTER");
		test2 = new Movie("2020", "MyTest", "5", "whateverSource");
		merged = test1.mergeSimilarMovie(test2);
		assertEquals("", merged!=null?merged.toString():"");
		//Should pass the test
		test1 = new Movie("2020", "MyTest", "-1", "IMDBIMPORTER");
		test2 = new Movie("2020", "MyTest", "4", "whateverSource");
		merged = test1.mergeSimilarMovie(test2);
		assertEquals("2020\tMyTest\t-1\tIMDBIMPORTER;whateverSource", merged!=null?merged.toString():"");
	}
	/*******************TESTS FOR UTILITIES CLASS********************/
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * Tests the isNumber from Utilities class.
	 * The tests consist on testing for negative numbers, as well as positive numbers.
	 * */
	@Test
	void testUtilitiesIsNumber() {
		String s;
		//Test for true cases.
		s = "5";
		assertEquals(true, Utilities.isNumber(s));
		s="126546864";
		assertEquals(true, Utilities.isNumber(s));
		s="-2365136";
		assertEquals(true, Utilities.isNumber(s));
		s="0";
		assertEquals(true, Utilities.isNumber(s));
		//Tests for false cases.
		s = "54674564674 ";
		assertEquals(false, Utilities.isNumber(s));
		s = "34543jk31345";
		assertEquals(false, Utilities.isNumber(s));
		s = "-31123jk35";
		assertEquals(false, Utilities.isNumber(s));
		s="-0";
		assertEquals(true, Utilities.isNumber(s));
	}
	/*******************TESTS FOR KAGGLE IMPORTER********************/
	/**
	 * @author Nael Louis
	 * This method tests the process() method of the KaggleImporter class
	 * Two ArrayList<String> are hardcoded, one, testList, as an input to process() and the other as the expected result 
	 * to the process() method. 
	 */
	@Test
	void testKaggleImporter() {
		ArrayList<String> testList = new ArrayList<>();
		testList.add("Cast 1	Cast 2	Cast 3	Cast 4	Cast 5	Cast 6	Description	Director 1	Director 2	Director 3	Genre	Rating	Release Date	Runtime	Studio	Title	Writer 1	Writer 2	Writer 3	Writer 4	Year");
		testList.add("Brendan Fraser	John Hannah	Maria Bello	Michelle Yeoh	Jet Li	Russell Wong\tThe Fast and the Furious director Rob Cohen continues the tale set into motion by director Stephen Sommers with this globe-trotting adventure that finds explorer Rick O'Connell and son attempting to thwart a resurrected emperor's (Jet Li) plan to enslave the entire human race. It's been 2,000 years since China's merciless Emperor Han and his formidable army were entombed in terra cotta clay by a double-dealing sorceress (Michelle Yeoh), but now, after centuries in suspended animation, an ancient curse is about to be broken. Thanks to his childhood adventures alongside father Rick (Brendan Fraser) and mother Evelyn (Maria Bello), dashing young archeologist Alex O'Connell (Luke Ford) is more than familiar with the power of the supernatural. After he is tricked into awakening the dreaded emperor from his eternal slumber, however, the frightened young adventurer is forced to seek out the wisdom of his parents -- both of whom have had their fair share of experience battling the legions of the undead. Should the fierce monarch prove capable of awakening his powerful terra cotta army, his diabolical plan for world domination will finally be set into motion. Of course, the one factor that this emperor mummy failed to consider while solidifying his power-mad plans was the O'Connells, and before this battle is over, the monstrous monarch will be forced to contend with the one family that isn't frightened by a few rickety reanimated corpses. ~ Jason Buchanan, Rovi\tRob Cohen	Simon Duggan	Director Not Available	Action	PG-13 	7/24/2008	112 minutes	Universal Pictures	The Mummy: Tomb of the Dragon Emperor	Alfred Gough	Miles Millar	Writer Not Available	Writer Not Available	2008");
		testList.add("Brendan Fraser\tFast & Furious 2\t20-05-2010\t2010");
		KaggleImporter kaggle = new KaggleImporter(c3P0SourceDir, c3P0OutputDir);
		ArrayList<String> processed = kaggle.process(testList);
		ArrayList<String> expected = new ArrayList<>();
		expected.add("Year\tTitle\tRuntime\tkaggle");
		expected.add("2008\tThe Mummy: Tomb of the Dragon Emperor\t112 minutes\tkaggle");
		assertEquals(expected, processed);
	}
	
	/*******************TESTS FOR NORMALIZER CLASS*******************/
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
	/*******************TESTS FOR IMDB IMPORTER**********************/
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * This method tests the process() method.
	 * It will give some sample inputs as an ArrayList<String> and 
	 * check if the return is processed properly.
	 */
	@Test
	void testImdbMovieImporterProcess() {
		ImdbImporter imdb = new ImdbImporter(r2d2SourceDir, r2d2OutputDir);
		ArrayList<String> input = new ArrayList<String>();
		input.add("imdb_title_id\ttitle\toriginal_title\tyear\tdate_published\tgenre\tduration\tcountry\tlanguage\tdirector\twriter\tproduction_company\tactors\tdescription\tavg_vote\tvotes\tbudget\tusa_gross_income\tworlwide_gross_income\tmetascore\treviews_from_users\treviews_from_critics");
		input.add("tt0001892\tDen sorte dr�m\tDen sorte dr�m\t1911\t8/19/1911\tDrama\t53\t\"Germany, Denmark\"\t\tUrban Gad\t\"Urban Gad, Gebhard Sch�tzler-Perasini\"\tFotorama\t\"Asta Nielsen, Valdemar Psilander, Gunnar Helsengreen, Emil Albes, Hugo Flink, Mary Hagen\"\t\"Two men of high rank are both wooing the beautiful and famous equestrian acrobat Stella. While Stella ignores the jeweler Hirsch, she accepts Count von Waldberg's offer to follow her home, ...\"\t5.8\t188\t\t\t\t\t5\t2");
		input.add("sampleImbdTitle	sampleTitle	sampleoriginalTitle		datepublished			country															");
		ArrayList<String> imported = imdb.process(input);
		ArrayList<String> expected = new ArrayList<String>();
		expected = new ArrayList<String>();
		expected.add("year\ttitle\tduration\timdb");
		expected.add("1911\tDen sorte dr�m\t53\timdb");
		expected.add("\tsampleTitle\t\timdb");
		assertEquals(expected, imported);
	}
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
		try {
			validated = validator.process(input);
			expected.add("-0\tmyTitle\t0\tkaggle");
			expected.add("-10000\tAvengers\t180\tkaggle");
			expected.add("1911\tDen sorte dr�m\t53\timdb");
			assertEquals(expected, validated);
		}
		catch (Exception e) {
			fail("Should not receive an Exception: "+e.getMessage());
		}
	}
}
