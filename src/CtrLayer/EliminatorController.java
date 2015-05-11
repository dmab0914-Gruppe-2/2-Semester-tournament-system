package CtrLayer;

import DBLayer.DBConnection;
import ModelLayer.Match;
import ModelLayer.SingleElimination;
import ModelLayer.Team;
import ModelLayer.Tournament;

import java.util.ArrayList;

/**
 * Created by Andreas on 09-05-2015.
 */
public class EliminatorController {
    private ArrayList<Team> teams;
    private Tournament t;
    private SingleElimination singleElimination;


    public EliminatorController() {
        generateDummyTeams();
    }//endConstructor

    public void generateDummyTeams() {

    }

    public ArrayList<Match> generateSETournament()
    {
        return singleElimination.generateSETournament(teams);
    }

    public Tournament generateDETournament(ArrayList<Team> teams) {
        return new Tournament();
    }

    public ArrayList<Team> getTeams(int tournamentId)
    {
        return t.getTeams();
    }

}//endClass
