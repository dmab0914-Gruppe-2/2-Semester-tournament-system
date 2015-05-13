package ModelLayer;

/**
 * Created by Andreas on 12-05-2015.
 */
public class WrongDataInputException extends RuntimeException {

	private static final long serialVersionUID = 3439373942567435517L;
	private String input;

	/**
	 * 
	 */
	public WrongDataInputException(String input) {
		this.input = input;
	}

	public String toString(){
		return input;
	}
}
