package CtrLayer;

import java.util.ArrayList;

import DBLayer.DBTournament;
import DBLayer.IFDBMatch;
import DBLayer.IFDBTournament;
import ModelLayer.Match;
import ModelLayer.Team;
import ModelLayer.Tournament;

/**
 * @author Jacob 13/05/2015
 *
 */
public class TournamentController implements IFTournamentController {

	private IFEliminationController eliminationController;
	private IFDBTournament dbTournament;
	private IFDBMatch dbMatch;

	public TournamentController() {
		eliminationController = new EliminationController();
		dbTournament = new DBTournament();
		//dbMatch = new DBMatch();
	}

	public ArrayList<Tournament> getTournaments() {
		return dbTournament.getTournaments(false);
	}

	public Tournament getTournamet(int tournamentID) {
		return dbTournament.getTournament(tournamentID, true); 
	}

	public boolean enableSignup(int tournamentID) {
		return dbTournament.enableSignup(tournamentID);
	}

	/**
	 * Starts the tournament form the given id if it exists. Gets the matches generated and added to db.
	 * @param	tournamentID	the id of the tournament
	 * @return	The matches that have been generated and started.
	 */
	public ArrayList<Match> startTournament(int tournamentID) throws Exception {
		if(dbTournament.startTournament(tournamentID)) {
			ArrayList<Team> teams = dbTournament.getTournamentTeams(tournamentID);
			//Asks for a list of matches from the given teams and given scores. As there isn't any scores to give atm, it asks for an empty ArrayList.
			ArrayList<Match> matches = eliminationController.generateRound(teams, new ArrayList<Integer>());
			ArrayList<Match> newMatches = new ArrayList<Match>(); //new list with the matches including their id. makes it easier to revert in case one gives an error.
			for(int i = 0; i < matches.size(); i++) {
				matches.get(i).setRoundNumber(1); //First round is always round 1. 
				try {
					newMatches.add(dbMatch.addmatch(matches.get(i)));
				}
				catch(Exception e) { //In case something happened. It will roll back the changes, without having to lock the database.
					dbTournament.abortTurnament(tournamentID);
					for(Match match : newMatches) {
						dbMatch.removeMatch(match.getId()); //Removes every match that have been added to the db.
					}
					e.printStackTrace(); //Something happened
					throw new Exception("Something happened, start of Tournament aborted.");
				}
			}
			return newMatches; //Returns the new list of matches which now also have an id from/in the database.
		}
		return null;
	}

	public boolean setMatchResults(int matchID, int team1Score, int team2Score) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Match> advanceTournament(int tournamentID) {
		// TODO Auto-generated method stub
		return null;
	}

	public Tournament endTournament(int tournamentID) {
		// TODO Auto-generated method stub
		return null;
	}

}
