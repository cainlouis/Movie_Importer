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
	 * @author Juan-Carlos Sreng-Flores
	 * This method checks whether the inputs given in the constructor are valid inputs.
	 * If the names are null or "", the method returns false.
	 * If the releaseYear or the runtime is NaN, it also returns false.
	 * If everything is acceptable according the conditions, it returns true;
	 * 
	 * @return boolean the validity of the Movie Object*/
	public boolean isValidMovie() {
		boolean valid = !(this.name == null || this.name.equals(""));
		valid = valid && !(this.source == null || this.source.equals(""));
		
		try {
			Integer.parseInt(this.releaseYear);
			Integer.parseInt(this.runtime);
		}
		catch (NumberFormatException n) {
			valid = false;
		}
		return valid;
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
