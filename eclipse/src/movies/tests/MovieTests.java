package movies.tests;

import movies.importer.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Juan-Carlos Sreng-Flores
 * @author Nael Louis
 * JUnit test class to test the Movie class
 */
class MovieTests {
	
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
	 * @author Juan-Carlos Sreng-Flores
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
		assertEquals("2020\t\t5\tkaggle;imdb", merged!=null?merged.toString():"");
		//Should fail the test
		test1 = new Movie("2020", "MyTest", "-1", "IMDBIMPORTER");
		test2 = new Movie("2020", "MyTest", "5", "whateverSource");
		merged = test1.mergeSimilarMovie(test2);
		assertEquals("", merged!=null?merged.toString():"");
		//Should pass the test
		test1 = new Movie("2020", "MyTest", "-1", "IMDBIMPORTER");
		test2 = new Movie("2020", "MyTest", "4", "whateverSource");
		merged = test1.mergeSimilarMovie(test2);
		test1 = new Movie("2020", "MyTest", "4", "anotherSource");
		merged = merged.mergeSimilarMovie(test1);
		assertEquals("2020\tMyTest\t-1\tIMDBIMPORTER;whateverSource;anotherSource", merged!=null?merged.toString():"");
		test1 = new Movie("2020", "MyTest", "4", "anotherSource2");
		merged = test1.mergeSimilarMovie(merged);
		assertEquals("2020\tMyTest\t4\tanotherSource2;IMDBIMPORTER;whateverSource;anotherSource", merged!=null?merged.toString():"");
	}
}
