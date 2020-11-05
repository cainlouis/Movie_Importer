package movies.importer;

public class Movie {
	private String releaseYear;
	private String name;
	private String runtime;
	private String source;
	
	/**
	 * @author Nael Louis
	 * @author Juan-Carlos Sreng-Flores
	 * 
	 * 
	 * */
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
	 * */
	public String getReleaseYear() {
		return this.releaseYear;
	}
	/**
	 * @author Nael Louis
	 * This method is a getter method for name attribute 
	 * of the Movie class.
	 * 
	 * @return the name attribute.
	 * */
	public String getName() {
		return this.name;
	}
	/**
	 * @author Nael Louis
	 * This method is a getter method for runtime attribute 
	 * of the Movie class.
	 * 
	 * @return the runtime attribute.
	 * */
	public String getRuntime() {
		return this.runtime;
	}
	/**
	 * @author Nael Louis
	 * This method is a getter method for source attribute 
	 * of the Movie class.
	 * 
	 * @return the source attribute.
	 * */
	public String getSource() {
		return this.source;
	}
	/**
	 * @author Nael Louis
	 * @author Juan-Carlos Sreng-Flores 
	 * This method overrides toString() method from Object class.
	 * 
	 * @return the String version of the Movie Object.
	 * */
	@Override
	public String toString() {
		return this.releaseYear+"\t"+this.name+"\t"+this.runtime+"\t"+this.source;
	}
	
}
