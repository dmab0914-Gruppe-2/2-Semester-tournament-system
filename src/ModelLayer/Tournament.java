package ModelLayer;

import ModelLayer.Team;

import java.util.ArrayList;

/**
 * Created by Andreas on 10-05-2015.
 */
public class Tournament {
    private ArrayList<Team> teams;
    private ArrayList<Match> matches;
    private ArrayList<Integer> score;
    private int tournamentId;

    public Tournament(ArrayList<Team> teams) {
        this.teams = teams;
    }//end Constructor

    public Tournament(ArrayList<Team> teams, ArrayList<Integer> scores){
        this.teams = teams;
        this.score = scores;
    }

    public Tournament(){

    }


    public ArrayList<Team> getTeams() {
        return teams;
    }

    public int getTournamentId()
    {
        return tournamentId;
    }
}//endClass
