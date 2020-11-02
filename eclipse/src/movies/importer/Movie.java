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
		//return values of the different methods separated by a tab
		//not sure of what he is asking to do here??
	}
	
	/*You may also add additional methods, including public ones, to this class if you think they would 
	 *help with your other tasks. In this case, you should use your best judgement as to whether this 
	 * is following good coding practice. You may of course ask your teacher for guidance here if you’re 
	 * unsure!
	 */
}
