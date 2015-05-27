package CtrLayer;

import java.util.ArrayList;

import DBLayer.DBTournament;
import DBLayer.DBTournamentTeams;
import DBLayer.IFDBMatch;
import DBLayer.IFDBTournament;
import DBLayer.IFDBTournamentTeams;
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
		// dbMatch = new DBMatch();
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
	 * Starts the tournament form the given id if it exists. Gets the matches
	 * generated and added to db.
	 * 
	 * @param tournamentID
	 *            the id of the tournament
	 * @return The matches that have been generated and started.
	 */
	public ArrayList<Match> startTournament(int tournamentID) throws Exception {
		if (dbTournament.startTournament(tournamentID)) {
			ArrayList<Team> teams = dbTournament
					.getTournamentTeams(tournamentID);
			// Asks for a list of matches from the given teams and given scores.
			// As there isn't any scores to give atm, it asks for an empty
			// ArrayList.
			ArrayList<Match> matches = eliminationController.generateRound(
					teams, new ArrayList<Integer>());
			// new list with the matches including their id. makes it easier to
			// revert in case one gives an error.
			ArrayList<Match> newMatches = new ArrayList<Match>();
			for (int i = 0; i < matches.size(); i++) {
				matches.get(i).setRoundNumber(1); // First round is always round
				// 1.
				try {
					newMatches.add(dbMatch.addmatch(matches.get(i)));
				} catch (Exception e) { // In case something happened. It will
					// roll back the changes, without having
					// to lock the database.
					dbTournament.abortTurnament(tournamentID);
					for (Match match : newMatches) {
						dbMatch.removeMatch(match.getId()); // Removes every
															// match that have
															// been added to the
															// db.
					}
					e.printStackTrace(); // Something happened
					throw new Exception(
							"Something happened, start of Tournament aborted.");
				}
			}
			return newMatches; // Returns the new list of matches which now also
			// have an id from/in the database.
		}
		return null;
	}

	public int setMatchResults(int matchID, int team1Score, int team2Score) {
		return dbMatch.setMatchResults(matchID, team1Score, team2Score);
	}

	@SuppressWarnings("unused")
	public ArrayList<Match> advanceTournament(int tournamentID) {
		ArrayList<Team> wTeams = new ArrayList<Team>();
		ArrayList<Integer> wScore = new ArrayList<Integer>();

		Tournament t = dbTournament.getTournament(tournamentID, false);

		ArrayList<Match> lastRound = dbMatch.getMatches(tournamentID);
		int i = 0;
		for (Match lr : lastRound) {
			if (lr.getRoundNumber() == t.getRoundNumber()) {
				if (lr.getTeam1Score() > lr.getTeam2Score()) {
					wTeams.add(i, lr.getTeam1());
					wScore.add(i, lr.getTeam1Score());
				} else {
					wTeams.add(i, lr.getTeam2());
					wScore.add(i, lr.getTeam2Score());
				}
			}
			i++;
		}
		try {
			int rn = dbTournament.advanceTournament(tournamentID);
			ArrayList<Match> newMatches = eliminationController.generateRound(
					wTeams, wScore);
			for (Match nw : newMatches) {
				nw.setRoundNumber(nw.getRoundNumber() + 1);
			}
			return newMatches;
		} catch (Exception e) {
			System.out.println("Error in advance tournament: " + e);
			return null;
		}
	}

	public Tournament endTournament(int tournamentID) {
		return dbTournament.endTournament(tournamentID);
	}

	@Override
	public void addTeamToTournament(Tournament tournament, Team team)
			throws Exception {
		IFDBTournamentTeams dbTT = new DBTournamentTeams();

		try {
			dbTT.addTeamToTournament(tournament.getId(), team.getId());
		} catch (Exception e) {
			throw new Exception("Error: Team not added!");
		}
	}

	@Override
	public void removeTeamFromTournament(Tournament tournament, Team team)
			throws Exception {
		IFDBTournamentTeams dbTT = new DBTournamentTeams();
		
		try {
			dbTT.removeTeamFromTournament(tournament.getId(), team.getId());
		} catch (Exception e) {
			throw new Exception("Error: Team not removed!");
		}
	}

	@Override
	public ArrayList<Team> getTournamentTeams(int tournamentID) {
		IFDBTournamentTeams dbTT = new DBTournamentTeams();
		return dbTT.getTeamsFromTournament(tournamentID);
	}

	@Override
	public ArrayList<Tournament> getTournamentFromTeam(int teamID) {
		IFDBTournamentTeams dbTT = new DBTournamentTeams();
		return dbTT.getTournamentFromTeams(teamID);
	}
}
