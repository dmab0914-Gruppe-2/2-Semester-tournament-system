package ModelLayer;

import ModelLayer.Team;
import ModelLayer.Match;

import java.util.ArrayList;

/**
 * @author Jacob 12/05/2015
 */
public class Tournament {

	/*
	 * waiting = tournament is waiting to be opened for accepting teams
	 * ready = tournament is ready for teams to signup
	 * running = tournament is in progress
	 * done = tournament is done
	 * cancelled = tournament is cancelled
	 */
	public enum Status {
		waiting, ready, running, done, cancelled
	}

	private int id;
	private String name;
	private String gameName;
	private int teamSize;
	private boolean withPlayOff;
	private Status status;
	private Team winnerTeam; //The team that won the tournament. Will only be defined if the status is done.
	private int roundNumber;
	private ArrayList<Team> teams;
	private ArrayList<Match> matches;

	public Tournament(){

	}

	public Tournament(int id, String name, String gameName, int teamSize, boolean withPlayOff, Status status, Team winnerTeam, int roundNumber, ArrayList<Team> teams, ArrayList<Match> matches) {
		this.id = id;
		this.name = name;
		this.gameName = gameName;
		this.teamSize = teamSize;
		this.withPlayOff = withPlayOff;
		this.status = status;
		this.winnerTeam = winnerTeam;
		this.roundNumber = roundNumber;
		this.teams = teams;
		this.matches = matches;
	}
	
	public Tournament(int id, String name, String gameName, int teamSize, boolean withPlayOff, Status status, Team winnerTeam, int roundNumber) {
		this.id = id;
		this.name = name;
		this.gameName = gameName;
		this.teamSize = teamSize;
		this.withPlayOff = withPlayOff;
		this.status = status;
		this.winnerTeam = winnerTeam;
		this.roundNumber = roundNumber;
	}
	
	public Tournament(int id, String name, String gameName, int teamSize, boolean withPlayOff, Status status) {
		this.id = id;
		this.name = name;
		this.gameName = gameName;
		this.teamSize = teamSize;
		this.withPlayOff = withPlayOff;
		this.status = status;
		this.roundNumber = 1;
	}
	
	public Tournament(String name, String gameName, int teamSize, boolean withPlayOff, Status status) {
		this.name = name;
		this.gameName = gameName;
		this.teamSize = teamSize;
		this.withPlayOff = withPlayOff;
		this.status = status;
		this.roundNumber = 1;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gameName
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * @param gameName the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * @return the teamSize
	 */
	public int getTeamSize() {
		return teamSize;
	}

	/**
	 * @param teamSize the teamSize to set
	 */
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	/**
	 * @return the withPlayOff
	 */
	public boolean isWithPlayOff() {
		return withPlayOff;
	}

	/**
	 * @param withPlayOff the withPlayOff to set
	 */
	public void setWithPlayOff(boolean withPlayOff) {
		this.withPlayOff = withPlayOff;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the winnerTeam
	 */
	public Team getWinnerTeam() {
		return winnerTeam;
	}

	/**
	 * @param winnerTeam the winnerTeam to set
	 */
	public void setWinnerTeam(Team winnerTeam) {
		this.winnerTeam = winnerTeam;
	}

	/**
	 * @return the roundNumber
	 */
	public int getRoundNumber() {
		return roundNumber;
	}

	/**
	 * @param roundNumber the roundNumber to set
	 */
	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}

	/**
	 * @return the teams
	 */
	public ArrayList<Team> getTeams() {
		return teams;
	}

	/**
	 * @param teams the teams to set
	 */
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	/**
	 * @return the matches
	 */
	public ArrayList<Match> getMatches() {
		return matches;
	}

	/**
	 * @param matches the matches to set
	 */
	public void setMatches(ArrayList<Match> matches) {
		this.matches = matches;
	}
	
	/**
	 * Converts the status to the specified id in the database.
	 * @param status The status to get related integer for
	 * @return	The related integer handwritten in db.
	 */
	public int statusToInt(Status status) {
		if(status.equals(Status.waiting)) {
			return 1;
		}
		if(status.equals(Status.ready)) {
			return 2;
		}
		if(status.equals(Status.running)) {
			return 3;
		}
		if(status.equals(Status.done)) {
			return 4;
		}
		if(status.equals(Status.cancelled)) {
			return 5;
		}
		return 0;
	}
	
	/**
	 * Converts the statusID to the specified Status in the database.
	 * @param	statusID The id to get the related Status for
	 * @return	The related Status handwritten in db.
	 */
	public Status IntToStatus(int statusID) {
		if(statusID == 1) {
			return Status.waiting;
		}
		if(statusID == 2) {
			return Status.ready;
		}
		if(statusID == 3) {
			return Status.running;
		}
		if(statusID == 4) {
			return Status.done;
		}
		if(statusID == 5) {
			return Status.cancelled;
		}
		return null;
	}
}//endClass
