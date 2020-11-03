package movies.importer;

import java.util.ArrayList;

public class KaggleImporter extends Processor {
	
	public KaggleImporter(String source, String destination) {
		super(source, destination, true);
	}
	
	public ArrayList<String> process(ArrayList<String> input) {
		int columnNum = 0;
		int nameIndex = 0; 
		int runtimeIndex = 0; 
		int yearIndex = 0;
		ArrayList<String> processed = new ArrayList<String>();
		String[] separated = input.get(0).split("\\t");
		
		columnNum = separated.length;
		for (int i = 0; i < columnNum; i++) {
			if (separated[i] == "Runtime") {
				runtimeIndex = i;
			}
			if (separated[i] == "Title") {
				nameIndex = i;
			}
			if (separated[i] == "Year") {
				yearIndex = i;
			}
		}
		
		for (int i = 0; i < input.size(); i++) {
			separated = input.get(i).split("\\t");
			if (separated.length == columnNum) {
				Movie newMovie = new Movie(separated[yearIndex], separated[nameIndex], separated[runtimeIndex], "kaggle");
				processed.add(newMovie.toString());
			}
		}
		return processed;
	}
	
}
