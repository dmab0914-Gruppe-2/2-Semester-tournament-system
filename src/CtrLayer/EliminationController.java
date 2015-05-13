package CtrLayer;

import ModelLayer.*;

import java.util.ArrayList;

/**
 * Created by Andreas on 09-05-2015.
 */
public class EliminationController {
    private SingleElimination singleElimination;


    public EliminationController() {
        singleElimination = new SingleElimination();

        //generateSETournament(generateDummyTeams(), new ArrayList<Integer>());
    }//endConstructor

    /**
     * Generates dummy classes for testing purposes
     * @return list of dummy classes
     */
    public ArrayList<Team> generateDummyTeams() {
        int i= 0;
        ArrayList<Team> teams = new ArrayList<>();
        while(i<11){
            String s = "The Awesome Thingy No." + Integer.toString(i);
            Team team = new Team(s, new ArrayList<User>());
            System.out.println("Team name: " + s);
            teams.add(team);
            i++;
        }
        return teams;
    }//endMethod

    /**
     *
     * @param teams A list of participating teams in the set of matches
     * @param scores A list of scores from last Round which is being used to generate next round with set scores.
     *               If this is the first match, throw an empty list of scores and a random setup will be generated
     * @return ArrayList of Match(es) to be played
     */
    public ArrayList<Match> generateSERound(ArrayList<Team> teams, ArrayList<Integer> scores)
    {
        System.out.println("Match lineup: ");
        ArrayList<Match> matches;

        try{
            matches = singleElimination.generateSERound(teams, scores);
            return matches;
        }
        catch (WrongDataInputException e){
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
        catch(IndexOutOfBoundsException e){
            System.out.println(e);
            e.printStackTrace();
            return null;
        }//endTryCatch

    }//endMethod

}//endClass
