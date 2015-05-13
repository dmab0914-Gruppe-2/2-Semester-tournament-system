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
	
	public Match addmatch(Match match);
	
	public Match removeMatch(int matchID);
	
	public boolean setMatchResults(int matchID, int team1Score, int team2Score);
	
	public ArrayList<Match> getMatches(int tournamentID);
}
