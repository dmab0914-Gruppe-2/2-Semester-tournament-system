package ModelLayer;

import java.util.ArrayList;

/**
 * Created by Andreas on 10-05-2015.
 */
public class Team {

    private String name;
    private ArrayList<Player> players;

    public Team(String name, ArrayList<Player> players) {
        this.name = name;
        this.players = players;
    }
}
