package CtrLayer;

import java.util.ArrayList;

import ModelLayer.Match;
import ModelLayer.Team;

public interface IFEliminationController {

	/**
	 * Generates dummy classes for testing purposes
	 * @return list of dummy classes
	 */
	public abstract ArrayList<Team> generateDummyTeams();//endMethod

	/**
	 *
	 * @param teams A list of participating teams in the set of matches
	 * @param scores A list of scores from last Round which is being used to generate next round with set scores.
	 *               If this is the first match, throw an empty list of scores and a random setup will be generated
	 * @return ArrayList of Match(es) to be played
	 */
	public abstract ArrayList<Match> generateSERound(ArrayList<Team> teams, ArrayList<Integer> scores);//endMethod

}