package movies.tests;
import movies.importer.*;
import java.io.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MovieTests {
	//srcDir and outputDir for IMDB movie importer
	public static String imdbSourceDir = "";
	public static String imdbOutputDir = "";
	//srcDir and outputDir for KAGGLE movie importer
	public static String kaggleSourceDir = "";
	public static String kaggleOutputDir ="";
	
	/******************TESTS FOR MOVIE CLASS******************/
	
	/** @author Juan-Carlos Sreng-Flores
	 * 	@author Nael Louis
	 * This method tests the getter Method for the releaseYear attribute*/
	@Test
	void testMovieGetReleaseYear() {
		Movie movie = new Movie("2016", "Moana", "Any runtime", "C:\\MyDirectory\\AnotherDirectory");
		assertEquals("2016", movie.getReleaseYear());
	}
	
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * @author Nael Louis
	 * This method tests the getter method for the name attribute.*/
	@Test
	void testMovieGetName() {
		Movie movie = new Movie("2016", "Moana", "Any runtime", "C:\\MyDirectory\\AnotherDirectory");
		assertEquals("Moana", movie.getName());
	}
	
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * @author Nael Louis
	 * This method tests the getter method for the runtime attribute.*/
	@Test
	void testMovieGetRuntime() {
		Movie movie = new Movie("2016", "Moana", "Any runtime", "C:\\MyDirectory\\AnotherDirectory");
		assertEquals("Any runtime", movie.getRuntime());
	}
	
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * @author Nael Louis
	 * This method tests the getter method for the source attribute.*/
	@Test
	void testMovieGetSource() {
		Movie movie = new Movie("2016", "Moana", "Any runtime", "C:\\MyDirectory\\AnotherDirectory");
		assertEquals("C:\\MyDirectory\\AnotherDirectory", movie.getSource());
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
		Movie movie = new Movie("2016", "Moana", "Any runtime", "C:\\MyDirectory\\AnotherDirectory");
		assertEquals("2016\tMoana\tAny runtime\tC:\\MyDirectory\\AnotherDirectory", movie.toString());
	}
	/*******************TESTS FOR UTILITIES CLASS********************/
	
	/******************TESTS FOR KAGGLE IMPORTER******************/
	@Test
	void testKaggleImporter() {
		ArrayList<String> testList = new ArrayList<>();
		testList.add("Cast 1	Cast 2	Cast 3	Cast 4	Cast 5	Cast 6	Description	Director 1	Director 2	Director 3	Genre	Rating	Release Date	Runtime	Studio	Title	Writer 1	Writer 2	Writer 3	Writer 4	Year");
		testList.add("Brendan Fraser	John Hannah	Maria Bello	Michelle Yeoh	Jet Li	Russell Wong\tThe Fast and the Furious director Rob Cohen continues the tale set into motion by director Stephen Sommers with this globe-trotting adventure that finds explorer Rick O'Connell and son attempting to thwart a resurrected emperor's (Jet Li) plan to enslave the entire human race. It's been 2,000 years since China's merciless Emperor Han and his formidable army were entombed in terra cotta clay by a double-dealing sorceress (Michelle Yeoh), but now, after centuries in suspended animation, an ancient curse is about to be broken. Thanks to his childhood adventures alongside father Rick (Brendan Fraser) and mother Evelyn (Maria Bello), dashing young archeologist Alex O'Connell (Luke Ford) is more than familiar with the power of the supernatural. After he is tricked into awakening the dreaded emperor from his eternal slumber, however, the frightened young adventurer is forced to seek out the wisdom of his parents -- both of whom have had their fair share of experience battling the legions of the undead. Should the fierce monarch prove capable of awakening his powerful terra cotta army, his diabolical plan for world domination will finally be set into motion. Of course, the one factor that this emperor mummy failed to consider while solidifying his power-mad plans was the O'Connells, and before this battle is over, the monstrous monarch will be forced to contend with the one family that isn't frightened by a few rickety reanimated corpses. ~ Jason Buchanan, Rovi\tRob Cohen	Simon Duggan	Director Not Available	Action	PG-13 	7/24/2008	112 minutes	Universal Pictures	The Mummy: Tomb of the Dragon Emperor	Alfred Gough	Miles Millar	Writer Not Available	Writer Not Available	2008");
		testList.add("Brendan Fraser\tFast & Furious 2\t20-05-2010\t2010");
		KaggleImporter kaggle = new KaggleImporter(kaggleSourceDir, kaggleOutputDir);
		ArrayList<String> processed = kaggle.process(testList);
		ArrayList<String> expected = new ArrayList<>();
		expected.add("Year\tTitle\tRuntime\tkaggle");
		expected.add("2008\tThe Mummy: Tomb of the Dragon Emperor\t112 minutes\tkaggle");
		assertEquals(expected, processed);
	}
	
	/*******************TESTS FOR NORMALIZER CLASS*******************/
	@Test 
	void testNormalizer() {
		ArrayList<String> testList = new ArrayList<>();
		testList.add("Year\tTitle\tRuntime\tkaggle");
		testList.add("2008\tThe Mummy: Tomb of the Dragon Emperor\t112 minutes\tkaggle");
		Normalizer test = new Normalizer(kaggleSourceDir, kaggleOutputDir);
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
	 * */
	@Test
	void testImdbMovieImporterProcess() {
		ImdbImporter imdb = new ImdbImporter(imdbSourceDir, imdbOutputDir);
		ArrayList<String> input = new ArrayList<String>();
		input.add("imdb_title_id\ttitle\toriginal_title\tyear\tdate_published\tgenre\tduration\tcountry\tlanguage\tdirector\twriter\tproduction_company\tactors\tdescription\tavg_vote\tvotes\tbudget\tusa_gross_income\tworlwide_gross_income\tmetascore\treviews_from_users\treviews_from_critics");
		input.add("tt0001892\tDen sorte dr�m\tDen sorte dr�m\t1911\t8/19/1911\tDrama\t53\t\"Germany, Denmark\"\t\tUrban Gad\t\"Urban Gad, Gebhard Sch�tzler-Perasini\"\tFotorama\t\"Asta Nielsen, Valdemar Psilander, Gunnar Helsengreen, Emil Albes, Hugo Flink, Mary Hagen\"\t\"Two men of high rank are both wooing the beautiful and famous equestrian acrobat Stella. While Stella ignores the jeweler Hirsch, she accepts Count von Waldberg's offer to follow her home, ...\"\t5.8\t188\t\t\t\t\t5\t2");
		input.add("sampleImbdTitle	sampleTitle	sampleoriginalTitle		datepublished			country															");
		ArrayList<String> transformed = imdb.process(input);
		ArrayList<String> expected = new ArrayList<String>();
		expected = new ArrayList<String>();
		expected.add("year\ttitle\tduration\timdb");
		expected.add("1911\tDen sorte dr�m\t53\timdb");
		expected.add("\tsampleTitle\t\timdb");
		assertEquals(expected, transformed);
	}
	/*******************TESTS FOR IMDB IMPORTER**********************/
}
