package CtrLayer;

import java.util.ArrayList;

import DBLayer.DBTeam;
import DBLayer.DBTeamMembers;
import DBLayer.IFDBTeam;
import DBLayer.IFDBTeamMembers;
import ModelLayer.Team;
import ModelLayer.User;

public class TeamController implements IFTeamController {

	@Override
	public void addTeam(int id, String name, int leader) throws Exception {
		Team team = new Team();
		team.setId(id);
		team.setName(name);
		team.setLeader(leader);

		try {
			IFDBTeam dbTeam = new DBTeam();
			dbTeam.insertTeam(team);
		} catch (Exception e) {
			throw new Exception("Team not inserted");
		}
	}

	@Override
	public ArrayList<User> getTeamMembers(int teamId) {
		IFDBTeamMembers dbTM = new DBTeamMembers();
		return dbTM.getUsersFromTeam(teamId);
	}

	@Override
	public void addUserToTeam(User user, Team team) throws Exception {
		IFDBTeamMembers dbTM = new DBTeamMembers();

		try {
			dbTM.addUserToTeam(team.getId(), user.getUserID());
		} catch (Exception e) {
			throw new Exception("Error: Team member not added!");
		}
	}

	@Override
	public void removeUserFromTeam(User user, Team team) throws Exception {
		IFDBTeamMembers dbTM = new DBTeamMembers();

		try {
			dbTM.removeUserFromTeam(team.getId(), user.getUserID());
		} catch (Exception e) {
			throw new Exception("Error: Team member not removed!");
		}		
	}

	@Override
	public Team findTeam(String name) {
		IFDBTeam dbTeam = new DBTeam();

		return dbTeam.findTeamByName(name);
	}

	@Override
	public Team findTeamById(int id) {
		IFDBTeam dbTeam = new DBTeam();

		return dbTeam.findTeamById(id);
	}

	@Override
	public int updateTeam(int id, String name, int leader) {

		IFDBTeam dbTeam = new DBTeam();
		Team team = new Team();

		team.setId(id);
		team.setName(name);
		team.setLeader(leader);

		try {
			return dbTeam.updateTeam(team);
		} catch (Exception e) {
			System.out.println("Update exception in Team db: " + e);
			return -1;
		}
	}

	@Override
	public int deleteTeam(int id) {
		IFDBTeam dbTeam = new DBTeam();
		return dbTeam.deleteTeam(id);
	}

	@Override
	public ArrayList<Team> getAllTeams() {
		IFDBTeam dbTeam = new DBTeam();
		return dbTeam.getAllTeams();
	}

}
