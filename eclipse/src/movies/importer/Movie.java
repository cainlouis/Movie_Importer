package movies.importer;

public class Movie {
	private String releaseYear;
	private String name;
	private String runtime;
	private String source;
	
	/**
	 * @author Nael Louis
	 * @author Juan-Carlos Sreng-Flores
	 * This method is the constructor for the Movie class. It initializes all values 
	 * in the movie Object.
	 * @param releaseYear String representing the release year of a Movie. 
	 * @param name String representing the Movie name
	 * @param runtime String representing the Movie's duration or how long the movie is in minutes
	 * @param source String representing the source of the feed importer.
	 */
	public Movie(String releaseYear, String name, String runtime, String source) {
		if (releaseYear != null && name != null && runtime != null && source != null) {
			this.releaseYear = releaseYear;
			this.name = name;
			this.runtime = runtime;
			this.source = source;
		}
		else {
			throw new IllegalArgumentException("ARGUMENT CONTAINS NULL VALUE.");
		}
	}
	/** 
	 * @author Juan-Carlos Sreng-Flores
	 * This is a constructor method overloading. It takes as input a String and creates a movie from it.
	 * If the String does not satisfy the conditions (i.e have a \t 4 times) it throws an IllegalArgumentException.
	 * @param movie String containing the same format as Movie.toString() return method.
	 */
	public Movie(String movie) {
		boolean isValidMovie = false;
		if (movie != null) {
			String[] splitted = movie.split("\\t",-1);
			if (splitted.length == 4) {
				this.releaseYear = splitted[0];
				this.name = splitted[1];
				this.runtime = splitted[2];
				this.source = splitted[3];
				isValidMovie = true;
			}
		}
		if(!isValidMovie) {
			throw new IllegalArgumentException("STRING PROVIDED IS NOT VALID.");
		}
	}
	/**
	 * @author Nael Louis
	 * This method is a getter method for releaseYear attribute 
	 * of the Movie class.
	 * 
	 * @return the releaseYear attribute.
	 */
	public String getReleaseYear() {
		return this.releaseYear;
	}
	/**
	 * @author Nael Louis
	 * This method is a getter method for name attribute 
	 * of the Movie class.
	 * 
	 * @return the name attribute.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @author Nael Louis
	 * This method is a getter method for runtime attribute 
	 * of the Movie class.
	 * 
	 * @return the runtime attribute.
	 */
	public String getRuntime() {
		return this.runtime;
	}
	/**
	 * @author Nael Louis
	 * This method is a getter method for source attribute 
	 * of the Movie class.
	 * 
	 * @return the source attribute.
	 */
	public String getSource() {
		return this.source;
	}
	/** 
	 * @author Juan-Carlos Sreng-Flores
	 * The method mergeSimilarMovie is installed in the Movie class
	 * since it is very useful in terms of Object instances (i.e instead of using a method taking 2 parameters)
	 * and also because it belongs to an entity of Movie type Object.
	 * This method makes sure that the movies are equal(similar) before merging, then
	 * a new Movie object will hold the values of the source movie for the first 3 attributes:
	 * releaseYear, name, and runtime. 
	 * As for the source if they sources are equal, the merged movie will keep 1 source.
	 * If the sources are different, it will concatenate the sources this way:
	 * 		"source1;source2" where source1 is the instance Movie Object and source2 is the parameter of the method.
	 * Once the movie is merged it is returned. 
	 * If the two Movie objects are not equal, then the method returns null.
	 * @param duplicate a Movie Object where it the instance Movie Object is merged with.
	 * @return Movie object containing the merged Movie
	 */
	public Movie mergeSimilarMovie(Movie duplicate) {
		Movie merged = null;
		if (this.equals(duplicate)) {
			String[] instanceSources = this.source.split(";");
			String[] duplicateSources = duplicate.source.split(";");
			String mergedSource = this.source;
			
			for(String duplicateSource: duplicateSources) {
				boolean contains = false;
				for(String instanceSource : instanceSources) {
					contains = contains || instanceSource.equals(duplicateSource);	
				}
				if(!contains) {
					mergedSource += ";"+duplicateSource;
				}
			}
			
			merged = new Movie(this.releaseYear, this.name, this.runtime, mergedSource);
		}
		return merged;
	}
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * This method overrides the inherited equals method from the Object class in
	 * order to be used with a more specific purpose of equality between two Movie 
	 * objects.
	 * Two movies are considered the same if they have exactly the same title and release year and the 
	 * runtime between the two is no more than 5 minutes apart.
	 * @param object - Object the Object to be compared to the Movie instance Object.
	 * @return boolean - representing if the objects are equal or not.
	 */
	@Override
	public boolean equals(Object object) {
		boolean isValid = false;
		if(object != null && object instanceof Movie) {
			Movie movie = (Movie)object;
			isValid = this.name.equals(movie.name) && this.releaseYear.equals(movie.releaseYear);
			try {
				int instanceRuntime  = Integer.parseInt(this.runtime);
				int paramRuntime = Integer.parseInt(movie.runtime);
				if (instanceRuntime<paramRuntime)
					isValid = isValid && ((paramRuntime-instanceRuntime)<=5);
				else 
					isValid = isValid && ((instanceRuntime-paramRuntime)<=5);
			}
			catch (NumberFormatException e) {
				isValid = false;
			}
		}
		return isValid;
	}
	/** 
	 * @author Juan-Carlos Sreng-Flores
	 * Override hashCode in order to use it for Deduper class.
	 * Using prime numbers as multipliers for the hashFunction creates 
	 * more randomness in the hashCode return number. 
	 * @return int - hashCode of the object of type Movie.
	 */
	@Override
	public int hashCode() {
		final int prime = 89;
		int hashCode = 7;
		hashCode = prime * hashCode + ((name == null) ? 0 : name.hashCode());
		hashCode = prime * hashCode + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		return hashCode;
	}
	/**
	 * @author Nael Louis
	 * @author Juan-Carlos Sreng-Flores 
	 * This method overrides toString() method from Object class.
	 * 
	 * @return String - String version of the Movie Object.
	 */
	@Override
	public String toString() {
		return this.releaseYear+"\t"+this.name+"\t"+this.runtime+"\t"+this.source;
	}
	
}
