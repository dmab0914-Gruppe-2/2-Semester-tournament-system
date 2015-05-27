package ModelLayer;

import ModelLayer.Tournament.Status;

/**
 * Created by Andreas on 11-05-2015.
 * The class use the enum type Status from the Tournament Class, as they're identical.
 */
public class Match {

    private int id;
    private Team team1;
    private Team team2;
    private int team1Score;
    private int team2Score;
    private int roundNumber;
    private int tournamentId;
    private Status status; //Uses the enum Status from the Tournament class. Please check it out for usage information.

    public Match() {

    }
    
    public Match(int id, Team team1, Team team2, int team1Score, int team2Score, int roundNumber, int tournamentId, Status status) {
    	this.id = id;
    	this.team1 = team1;
    	this.team2 = team2;
    	this.team1Score = team1Score;
    	this.team2Score = team2Score;
    	this.roundNumber = roundNumber;
    	this.tournamentId = tournamentId;
    	this.status = status;
    }

	/**
	 * @return the tournamentId
	 */
	public int getTournamentId() {
		return tournamentId;
	}

	/**
	 * @param tournamentId the tournamentId to set
	 */
	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
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
	 * @return the team1
	 */
	public Team getTeam1() {
		return team1;
	}

	/**
	 * @param team1 the team1 to set
	 */
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	/**
	 * @return the team2
	 */
	public Team getTeam2() {
		return team2;
	}

	/**
	 * @param team2 the team2 to set
	 */
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	/**
	 * @return the team1Score
	 */
	public int getTeam1Score() {
		return team1Score;
	}

	/**
	 * @param team1Score the team1Score to set
	 */
	public void setTeam1Score(int team1Score) {
		this.team1Score = team1Score;
	}

	/**
	 * @return the team2Score
	 */
	public int getTeam2Score() {
		return team2Score;
	}

	/**
	 * @param team2Score the team2Score to set
	 */
	public void setTeam2Score(int team2Score) {
		this.team2Score = team2Score;
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
}
