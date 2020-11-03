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
		StringBuilder s = new StringBuilder();
		s.append("Movie name: "+this.name);
		s.append("\nRelease year: "+this.releaseYear);
		s.append("\nRuntime: "+this.runtime);
		s.append("\nSource: "+this.source);
		return s.toString();
	}
	
}
