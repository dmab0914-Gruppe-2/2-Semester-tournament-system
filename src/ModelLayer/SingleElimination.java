package ModelLayer;

import java.util.ArrayList;

/**
 * Created by Andreas on 09-05-2015.
 */
public class SingleElimination {

    public SingleElimination(ArrayList<Team> teams) {

    }//endConstructor

    public ArrayList<Match> generateSETournament(ArrayList<Team> teams) {

        if (teams.size() % 2 == 0) {
            System.out.println("Teams are divisible by two" + teams.size());

        } else if (teams.size() % 2 != 0) {
            System.out.println("Teams are NOT divisible by two" + teams.size());
        }


        return new ArrayList<Match>();
    }//end generateSETournament
}//endClass
