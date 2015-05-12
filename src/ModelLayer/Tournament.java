package ModelLayer;

import ModelLayer.Team;
import ModelLayer.Match;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Jacob 12/05/2015
 */
public class Tournament {

	enum Status {
		afventer, igangværende, afsluttet, anulleret
	}

	private int id;
	private String name;
	private String gameName;
	private int teamSize;
	private boolean withPlayOff;
	private Status status;
	private Date startTime;
	private Team winnerTeam;
	private int roundNumber;
	private ArrayList<Team> teams;
	private ArrayList<Match> matches;

	public Tournament(){

	}

	public Tournament(int id, String name, String gameName, int teamSize, boolean withPlayOff, Status status, Date startTime, Team winnerTeam, int roundNumber, ArrayList<Team> teams, ArrayList<Match> matches) {
		this.id = id;
		this.name = name;
		this.gameName = gameName;
		this.teamSize = teamSize;
		this.withPlayOff = withPlayOff;
		this.status = status;
		this.startTime = startTime;
		this.winnerTeam = winnerTeam;
		this.roundNumber = roundNumber;
		this.teams = teams;
		this.matches = matches;
	}
	
	public Tournament(int id, String name, String gameName, int teamSize, boolean withPlayOff, Status status, Date startTime, Team winnerTeam, int roundNumber) {
		this.id = id;
		this.name = name;
		this.gameName = gameName;
		this.teamSize = teamSize;
		this.withPlayOff = withPlayOff;
		this.status = status;
		this.startTime = startTime;
		this.winnerTeam = winnerTeam;
		this.roundNumber = roundNumber;
	}
	
	public Tournament(int id, String name, String gameName, int teamSize, boolean withPlayOff, Status status, Date startTime) {
		this.id = id;
		this.name = name;
		this.gameName = gameName;
		this.teamSize = teamSize;
		this.withPlayOff = withPlayOff;
		this.status = status;
		this.startTime = startTime;
	}
	
	public Tournament(int id, String name, String gameName, int teamSize, boolean withPlayOff, Status status) {
		this.id = id;
		this.name = name;
		this.gameName = gameName;
		this.teamSize = teamSize;
		this.withPlayOff = withPlayOff;
		this.status = status;
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
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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


}//endClass
