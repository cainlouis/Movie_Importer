package movies.importer;

public class Movie {
	private String releaseYear;
	private String name;
	private String runtime;
	private String source;
	
	public Movie(String releaseYear, String name, String runtime, String source) {
		this.releaseYear = releaseYear;
		this.name = name;
		this.runtime = runtime;
		this.source = source;
	}
	
	public String getReleaseYear() {
		return this.releaseYear;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getRuntime() {
		return this.runtime;
	}
	
	public String getSource() {
		return this.source;
	}
	
	public String toString() {
		return (this.name + "\t" + this.releaseYear + "\t" + this.runtime + "\t" + this.source);
	}
	
}
