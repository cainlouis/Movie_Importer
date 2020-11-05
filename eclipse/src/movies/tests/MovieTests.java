package movies.tests;
import movies.importer.Movie;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MovieTests {
	//srcDir and outputDir for IMDB movie importer
	public static String imdbSource = "";
	public static String imdbOutput = "";
	//srcDir and outputDir for KAGGLE movie importer
	public static String kaggleSource = "";
	public static String kaggleOutput ="";
	
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
	@Test
	void testImdbMovieImporter() {
		
	}
}
