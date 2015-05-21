package ModelLayer;

/**
 * Created by Andreas on 12-05-2015.
 */
public class WrongDataInputException extends RuntimeException {

	private static final long serialVersionUID = 3439373942567435517L;

	public WrongDataInputException(String input) {
		super(input);

	}
}
