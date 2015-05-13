package ModelLayer;


/**
 * Throwen if the searched object wasn't found.
 * It doesn't have much more functionality, than being something the program can throw and catch if needed.
 * 
 * @author Jacob Pedersen 13-05-2015 dd-mm-yyyy
 */
public class ObjectNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5028116364904774537L;
	private String error;

	/**
	 * Constructor for objects of class NonValidScoreException
	 */
	public ObjectNotFoundException(String error)
	{
		this.error = error;
	}
	
	public String toString() {
		return error;
	}
}
