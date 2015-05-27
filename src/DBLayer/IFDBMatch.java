/**
 * 
 */
package DBLayer;

import java.util.ArrayList;

import ModelLayer.Match;

/**
 * @author Jacob 12/05/2015
 *
 */
public interface IFDBMatch {
	
	public int addmatch(Match match) throws Exception;
	
	public int removeMatch(int matchID);
	
	public Match getMatch(int matchID);
	
	public int setMatchResults(int matchID, int team1Score, int team2Score);
	
	public ArrayList<Match> getMatches(int tournamentID);
}