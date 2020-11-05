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
	
	/******************TESTS FOR KAGGLE IMPORTER******************/
	
	
	/*******************TESTS FOR IMDB IMPORTER******************/
	/***
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
		input.add("tt0001892\tDen sorte drøm\tDen sorte drøm\t1911\t8/19/1911\tDrama\t53\t\"Germany, Denmark\"\t\tUrban Gad\t\"Urban Gad, Gebhard Schätzler-Perasini\"\tFotorama\t\"Asta Nielsen, Valdemar Psilander, Gunnar Helsengreen, Emil Albes, Hugo Flink, Mary Hagen\"\t\"Two men of high rank are both wooing the beautiful and famous equestrian acrobat Stella. While Stella ignores the jeweler Hirsch, she accepts Count von Waldberg's offer to follow her home, ...\"\t5.8\t188\t\t\t\t\t5\t2");
		input.add("sampleImbdTitle	sampleTitle	sampleoriginalTitle		datepublished			country															");
		ArrayList<String> transformed = imdb.process(input);
		ArrayList<String> expected = new ArrayList<String>();
		expected = new ArrayList<String>();
		expected.add("year\ttitle\tduration\timdb");
		expected.add("1911\tDen sorte drøm\t53\timdb");
		expected.add("\tsampleTitle\t\timdb");
		assertEquals(expected, transformed);
		
		
		
	}
}
