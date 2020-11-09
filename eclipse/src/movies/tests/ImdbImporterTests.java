package movies.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import movies.importer.ImdbImporter;

/** 
 * @author Juan-Carlos Sreng-Flores
 * JUnit test class to test the ImdbImporter Class process method
 */
class ImdbImporterTests {
	//srcDir and outputDir for IMDB movie importer and Validator class;
		public static String r2d2SourceDir = "";
		public static String r2d2OutputDir = "";
		
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

}
