package pobj.tme5;

@SuppressWarnings("serial")
public class InvalidMultiSetFormat extends Exception {
	
	public InvalidMultiSetFormat(String message) {
		super(message);
	}
	
	public InvalidMultiSetFormat(String message, Throwable cause) {
		super(message);
		cause.getCause();
	}
	
}
