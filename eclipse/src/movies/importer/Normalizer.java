package movies.importer;

import java.util.ArrayList;

public class Normalizer extends Processor {
	
	public Normalizer(String source, String destination) {
		super(source, destination, false);
	}
	
	public ArrayList<String> process(ArrayList<String> input) {
		ArrayList<String> processed = new ArrayList<>();
		
		for (String line : input) {
			String[] inputArr = line.split("\\t");
			Movie newMovie = new Movie(inputArr[0], inputArr[1], inputArr[2], inputArr[3]);
			
			inputArr[1] = inputArr[1].toLowerCase();
			String[] runtimeArr = newMovie.getRuntime().split("\\s");
			inputArr[2] = runtimeArr[0];
			Movie toList = new Movie(inputArr[0], inputArr[1], inputArr[2], inputArr[3]);
			processed.add(toList.toString());
		}
		return processed;
	}
}
