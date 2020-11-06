package movies.importer;
import movies.utilities.*;
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
		this.releaseYear = releaseYear;
		this.name = name;
		this.runtime = runtime;
		this.source = source;
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
	 * This method overrides the inherited equals method from the Object class in
	 * order to be used with a more specific purpose of equality between two Movie 
	 * objects.
	 * Two movies are considered the same if they have exactly the same title and release year and the 
	 * runtime between the two is no more than 5 minutes apart.
	 * @param object Object the Object to be compared to the Movie instance Object.
	 * @return boolean representing if the objects are equal or not.
	 */
	@Override
	public boolean equals(Object object) {
		boolean isValid = false;
		if(object instanceof Movie) {
			Movie movie = (Movie)object;
			isValid = this.name.equals(movie.getName()) && this.releaseYear.equals(movie.getReleaseYear());
			try {
				int instanceRuntime  = Integer.parseInt(this.runtime);
				int paramRuntime = Integer.parseInt(movie.getRuntime());
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
	 * @author Nael Louis
	 * @author Juan-Carlos Sreng-Flores 
	 * This method overrides toString() method from Object class.
	 * 
	 * @return the String version of the Movie Object.
	 */
	@Override
	public String toString() {
		return this.releaseYear+"\t"+this.name+"\t"+this.runtime+"\t"+this.source;
	}
	
}
