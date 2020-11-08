package movies.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import movies.importer.KaggleImporter;

class KaggleImporterTests {
	//srcDir and outputDir for KAGGLE movie importer and Normalizer class.
	public static String c3P0SourceDir = "";
	public static String c3P0OutputDir ="";
	
	//srcDir and outputDir for IMDB movie importer and Validator class;
	public static String r2d2SourceDir = "";
	public static String r2d2OutputDir = "";
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
		testList.add("");
		testList.add("Cast 1	Cast 2	Cast 3	Cast 4	Cast 5	Cast 6	Description	Director 1	Director 2	Director 3	Genre	Rating	Release Date	Runtime	Studio	Title	Writer 1	Writer 2	Writer 3	Writer 4	Year");
		testList.add("Brendan Fraser	John Hannah	Maria Bello	Michelle Yeoh	Jet Li	Russell Wong\tThe Fast and the Furious director Rob Cohen continues the tale set into motion by director Stephen Sommers with this globe-trotting adventure that finds explorer Rick O'Connell and son attempting to thwart a resurrected emperor's (Jet Li) plan to enslave the entire human race. It's been 2,000 years since China's merciless Emperor Han and his formidable army were entombed in terra cotta clay by a double-dealing sorceress (Michelle Yeoh), but now, after centuries in suspended animation, an ancient curse is about to be broken. Thanks to his childhood adventures alongside father Rick (Brendan Fraser) and mother Evelyn (Maria Bello), dashing young archeologist Alex O'Connell (Luke Ford) is more than familiar with the power of the supernatural. After he is tricked into awakening the dreaded emperor from his eternal slumber, however, the frightened young adventurer is forced to seek out the wisdom of his parents -- both of whom have had their fair share of experience battling the legions of the undead. Should the fierce monarch prove capable of awakening his powerful terra cotta army, his diabolical plan for world domination will finally be set into motion. Of course, the one factor that this emperor mummy failed to consider while solidifying his power-mad plans was the O'Connells, and before this battle is over, the monstrous monarch will be forced to contend with the one family that isn't frightened by a few rickety reanimated corpses. ~ Jason Buchanan, Rovi\tRob Cohen	Simon Duggan	Director Not Available	Action	PG-13 	7/24/2008	112 minutes	Universal Pictures	The Mummy: Tomb of the Dragon Emperor	Alfred Gough	Miles Millar	Writer Not Available	Writer Not Available	2008");
		testList.add("Brendan Fraser\tFast & Furious 2\t20-05-2010\t2010");
		testList.add(null);
		KaggleImporter kaggle = new KaggleImporter(c3P0SourceDir, c3P0OutputDir);
		ArrayList<String> processed = kaggle.process(testList);
		ArrayList<String> expected = new ArrayList<>();
		expected.add("Year\tTitle\tRuntime\tkaggle");
		expected.add("2008\tThe Mummy: Tomb of the Dragon Emperor\t112 minutes\tkaggle");
		assertEquals(expected, processed);
	}
	
}
