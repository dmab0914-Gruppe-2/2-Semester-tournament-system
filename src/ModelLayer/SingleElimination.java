package ModelLayer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Andreas on 09-05-2015.
 */
public class SingleElimination {


    public SingleElimination() {

    }//endConstructor

    public ArrayList<Match> generateSETournament(ArrayList<Team> teams, ArrayList<Integer> scores) {

        ArrayList<Match> matches = new ArrayList<>();
        if (scores.size() == 0) {

            if (teams.size() % 2 == 0) {
                System.out.println("Teams are divisible by two" + teams.size());

                for (int i = 0; i < teams.size(); i += 2) {
                    Random rnd = new Random();

                    Match match = new Match();
                    int rndNumber = rndNumber(teams.size());
                    Team team1 = teams.get(rndNumber);
                    match.setTeam1(team1);
                    teams.remove(team1);

                    rndNumber = rndNumber(teams.size());
                    Team team2 = teams.get(rndNumber);
                    match.setTeam2(team2);
                    matches.add(match);

                }//endFor

            } else if (teams.size() % 2 != 0) {

                System.out.println("Teams are NOT divisible by two" + teams.size());

                for (int i = 0; i < teams.size(); i += 2) {

                    if(teams.size() - i <= 3){
                        System.out.println("Teams - Index <= 3 ");
                        Random rnd = new Random();

                        Match match = new Match();
                        Team team1 = teams.get(rnd.nextInt(i));
                        match.setTeam1(team1);
                        teams.remove(team1);

                        Team team2 = teams.get(rnd.nextInt(i - 1));
                        match.setTeam2(team2);
                        matches.add(match);
                    }else if(teams.size() - i == 1){
                        System.out.println("Teams - Index == 1 ");

                    }//endIf
                }//endFor

            }
        }//endIf
        return matches;
    }//end generateSETournament

    public int rndNumber(int input){
        Random rnd = new Random();
        int i  = rnd.nextInt(input);
        //System.out.println("Uber Random Number " + i);
        return i;
    }//endRndNumber
}//endClass
