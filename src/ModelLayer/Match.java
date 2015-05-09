/**
 * 
 */
package ModelLayer;

/**
 * Contains opposing teams or players, and end scores if set. 
 * Currently limited to only two opponents in a match.
 * 
 * @author Jacob
 *
 */
public class Match {

	private Object opponent1;
	private Object opponent2;
	private int opponent1Score;
	private int opponent2Score;

	enum Empty {
		opponent1, opponent2, none, all
	}
	/**
	 * 
	 */
	public Match() {
		// TODO Auto-generated constructor stub
	}

	public Match(Object opponent1, Object opponent2) {
		this.setOpponent1(opponent1);
		this.opponent2 = opponent2;
	}

	/**
	 * 
	 * @return which one is empty, all if all are empty or none if none is empty.
	 */
	public Empty isEmpty() {
		if(opponent1 != null || opponent2 != null) {
			return Empty.none;
		}
		else if(opponent1 != null) {
			return Empty.opponent2;
		}
		else if(opponent2 != null) {
			return Empty.opponent1;
		}
		return Empty.all;
	}

	/**
	 * @return the opponent1
	 */
	public Object getOpponent1() {
		return opponent1;
	}

	/**
	 * @param opponent1 the opponent1 to set
	 */
	public void setOpponent1(Object opponent1) {
		this.opponent1 = opponent1;
	}
	
	public Object getOpponent2() {
		return opponent2;
	}

	public void setOpponent2(Object opponent2) {
		this.opponent2 = opponent2;
	}

	/**
	 * @return the opponent1Score
	 */
	public int getOpponent1Score() {
		return opponent1Score;
	}

	/**
	 * @param opponent1Score the opponent1Score to set
	 */
	public void setOpponent1Score(int opponent1Score) {
		this.opponent1Score = opponent1Score;
	}

	/**
	 * @return the opponent2Score
	 */
	public int getOpponent2Score() {
		return opponent2Score;
	}

	/**
	 * @param opponent2Score the opponent2Score to set
	 */
	public void setOpponent2Score(int opponent2Score) {
		this.opponent2Score = opponent2Score;
	}

}
