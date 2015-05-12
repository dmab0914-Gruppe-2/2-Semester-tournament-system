package CtrLayer;

import ModelLayer.*;

import java.util.ArrayList;

/**
 * Created by Andreas on 09-05-2015.
 */
public class EliminatorController {
    private SingleElimination singleElimination;


    public EliminatorController() {
        singleElimination = new SingleElimination();

        //generateSETournament(generateDummyTeams(), new ArrayList<Integer>());
    }//endConstructor

    public ArrayList<Team> generateDummyTeams() {
        int i= 0;
        ArrayList<Team> teams = new ArrayList<>();
        while(i<10){
            String s = "The Awesome Thingy No." + Integer.toString(i);
            Team team = new Team(s, new ArrayList<User>());
            System.out.println("Team name: " + s);
            teams.add(team);
            i++;
        }
        return teams;
    }

    /**
     *
     * @param teams A list of participating teams in the set of matches
     * @param scores A list of scores from last Round which is being used to generate next round with set scores.
     *               If this is the first match, throw an empty list of scores and a random setup will be generated
     * @return ArrayList of Match(es) to be played
     */
    public ArrayList<Match> generateSETournament(ArrayList<Team> teams, ArrayList<Integer> scores)
    {
        System.out.println("Match lineup: ");
        ArrayList<Match> matches = singleElimination.generateSETournament(teams, scores);
        for(int i = 0; i<matches.size(); i++){
            System.out.println(matches.get(i).getTeam1().getName());
            System.out.println(matches.get(i).getTeam2().getName());
        }
        return matches;
    }

}//endClass
