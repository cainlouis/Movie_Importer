package movies.importer;

import java.util.ArrayList;

public class Normalizer extends Processor {
	
	public Normalizer(String source, String destination) {
		super(source, destination, false);
	}
	
	public ArrayList<String> process(ArrayList<String> input) {
		String title;
		String runtime;
		ArrayList<String> processed = new ArrayList<>();
		
		for (int i = 0; i < input.size(); i++) {
			String[] inputArr = input.get(i).split("\\t");
			Movie newMovie = new Movie(inputArr[0], inputArr[1], inputArr[2], inputArr[3]);
			
			for (int j = 0; j < inputArr.length; j++) {
				title = newMovie.getName();
				if (inputArr[j] == title) {
					inputArr[j] = title.toLowerCase();
				}
				runtime = newMovie.getRuntime();
				if (inputArr[j] == runtime) {
					String[] runtimeArr = newMovie.getRuntime().split("\\s");
					inputArr[j] = runtimeArr[0];
				}
			}
			Movie toList = new Movie(inputArr[0], inputArr[1], inputArr[2], inputArr[3]);
			processed.add(toList.toString());
		}
		return processed;
	}
}
