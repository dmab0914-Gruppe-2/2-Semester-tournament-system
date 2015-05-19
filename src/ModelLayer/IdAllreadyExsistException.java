package ModelLayer;

public class IdAllreadyExsistException extends RuntimeException {
	private static final long serialVersionUID = 3439373942567435517L;
	private String input;

	/**
	 * 
	 */
	public IdAllreadyExsistException(String input) {
		this.input = input;
	}

	public String toString(){
		return input;
	}
}
