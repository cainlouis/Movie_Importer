package movies.utilities;

public class Utilities {
	
	/**
	 * @autrhor Juan-Carlos Sreng-Flores
	 * This method performs a try catch to find out if the 
	 * String given is a number.
	 * @param s String that possibly contains a number converted in String.
	 * @return boolean, true if it is a number, false if not.
	 * */
	public static boolean isNumber(String s) {
		boolean isNum;
		try {
			Integer.parseInt(s);
			isNum = true;
		}
		catch (NumberFormatException e) {
			isNum=false;
		}
		return isNum;
	}
}
