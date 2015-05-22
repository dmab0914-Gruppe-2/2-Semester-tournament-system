package ModelLayer;

import java.util.ArrayList;

/**
 * Created by Ronnie on 10-05-2015.
 */
public class Team {

    private String name;
    private int id;
    private int leader;
    private ArrayList<User> users;

    public Team(String name, ArrayList<User> users) {
        this.setName(name);
        this.setUsers(users);
        this.setId(id);
        this.setLeader(leader);
    }
    
    public Team(int id) {
    	this.id = id;
    }
    
    public Team(){
    
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}
	
	public String getIdAsString() {
		String s = Integer.toString(this.id);
		return s;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLeader() {
		return leader;
	}

	public void setLeader(int leader) {
		this.leader = leader;
	}
}
